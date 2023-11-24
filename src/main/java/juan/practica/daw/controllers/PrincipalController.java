package juan.practica.daw.controllers;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import juan.practica.daw.models.Usuario;
import juan.practica.daw.persistence.Admin_HibernateUtilPostgr;
import juan.practica.daw.persistence.dao.UsuarioDAO;
import static juan.practica.daw.persistence.validation.UserValidation.validarApellidos;
import static juan.practica.daw.persistence.validation.UserValidation.validarContraseña;
import static juan.practica.daw.persistence.validation.UserValidation.validarEmail;
import static juan.practica.daw.persistence.validation.UserValidation.validarNickName;
import static juan.practica.daw.persistence.validation.UserValidation.validarNombre;
import static juan.practica.daw.persistence.validation.UserValidation.validarRepitContraseña;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

@WebServlet(name = "PrincipalController", urlPatterns =
{
    "/home/*"
})
public class PrincipalController extends HttpServlet
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String accion = request.getPathInfo();
        String vista = null;
        //System.out.println(accion);

        switch (accion)
        {
            case "/IniciarSesion/":
            {
                vista = "/jsp/InicioSesion.jsp";
                break;
            }
            case "/IniciarSesion/CrearCuenta/":
            {
                vista = "/jsp/CreateAccount.jsp";
                break;
            }
            case "/IniciarSesion/Autenticacion/":
            {
                String usuario = request.getParameter("usuario");
                String contraseña = request.getParameter("contraseña");
                //String usuario = "Alex";
                //String contraseña = "1234567A";
                System.out.println(usuario);

                boolean autenticado = verificarCredenciales(usuario, contraseña);
                if (autenticado)
                {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("usuario", usuario);

                    // Redirige a la página principal después de la autenticación exitosa
                    //response.sendRedirect(request.getContextPath() + "/home/");
                    vista = "/jsp/index.jsp";
                } else
                {
                    // Redirige a la página de inicio de sesión con un parámetro de error
                    //response.sendRedirect(request.getContextPath() + "/home/IniciarSesion/?error=1");
                    vista = "/jsp/IniciarSesion.jsp";
                }
                break;
            }
            case "/Logout/":
            {
                HttpSession session = request.getSession(false);
                if (session != null)
                {
                    session.invalidate(); // Cierra la sesión actual
                    vista = "/jsp/Logout.jsp";
                }
                break;
            }
            case "/IniciarSesion/CrearCuenta/GuardarUsuario/":
            {
                String nombre = request.getParameter("nombre");
                String apellidos = request.getParameter("apellidos");
                String email = request.getParameter("email");
                String nickName = request.getParameter("usuario");
                String contraseña = request.getParameter("password");
                String repitContraseña = request.getParameter("repit_password");

                String salt = generateSalt();
                String hashedPassword = hashPassword(contraseña, salt);

                if (validarNombre(nombre) && validarApellidos(apellidos) && validarContraseña(contraseña)
                        && validarRepitContraseña(repitContraseña) && validarEmail(email)
                        && validarNickName(nickName))
                {
                    if (esNicknameUnico(nickName) && esEmailUnico(email))
                    {
                        //System.out.println("Entro aqui");
                        Usuario user = new Usuario(nombre, apellidos, email, nickName, hashedPassword, salt);
                        registrarEnBD(user);
                        vista = "/jsp/RegistroExitoso.jsp";
                    } else if (!esNicknameUnico(nickName))
                    {
                        vista = "/jsp/NickName_Repetido.jsp";
                    } else
                    {
                        vista = "/jsp/Email_Repetido.jsp";
                    }
                } else
                {
                    vista = "/jsp/RegistroFallido.jsp";
                }
                break;
            }
            default:
                vista = "/jsp/index.jsp";
                break;
        }
        RequestDispatcher rd = request.getRequestDispatcher(vista);
        rd.forward(request, response);
    }

    private void registrarEnBD(Usuario user)
    {
        Session session = Admin_HibernateUtilPostgr.getSessionFactory().openSession();
        UsuarioDAO usuarioDAO = new UsuarioDAO(session);
        usuarioDAO.save(user);
        session.close();
    }

    private boolean esNicknameUnico(String nickName)
    {
        boolean resultado;
        Session session = null;
        Transaction transaction = null;
        System.out.println(nickName);
        try
        {
            session = Admin_HibernateUtilPostgr.getSessionFactory().openSession();
            UsuarioDAO usuarioDAO = new UsuarioDAO(session);
            boolean esUnico = usuarioDAO.findByNickName(nickName);

            if (esUnico)
            {
                resultado = true;  // El email no existe en la base de datos
            } else
            {
                resultado = false;  // El email ya existe en la base de datos
            }
        } catch (HibernateException e)
        {
            if (transaction != null)
            {
                transaction.rollback();
            }
            resultado = false;
        } finally
        {
            if (session != null && session.isOpen())
            {
                session.close();
            }
        }
        return resultado;
    }

    private boolean esEmailUnico(String email)
    {
        boolean resultado;
        Session session = null;
        Transaction transaction = null;
        try
        {
            session = Admin_HibernateUtilPostgr.getSessionFactory().openSession();
            UsuarioDAO usuarioDAO = new UsuarioDAO(session);
            boolean esUnico = usuarioDAO.findByEmail(email);

            if (esUnico)
            {
                resultado = true;  // El email no existe en la base de datos
            } else
            {
                resultado = false;  // El email ya existe en la base de datos
            }
        } catch (HibernateException e)
        {
            if (transaction != null)
            {
                transaction.rollback();
            }
            resultado = false;
        } finally
        {
            if (session != null && session.isOpen())
            {
                session.close();
            }
        }
        return resultado;
    }

    private String generateSalt()
    {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    private String hashPassword(String password, String salt)
    {
        try
        {
            // Combinar la contraseña y la huella
            String passwordWithSalt = password + salt;

            // Obtener una instancia de MessageDigest
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Aplicar el hash a la combinación de contraseña y sal
            byte[] hashedBytes = md.digest(passwordWithSalt.getBytes());

            // Convertir el resultado a una representación en base64
            return Base64.getEncoder().encodeToString(hashedBytes);

        } catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    private boolean verificarContraseña(String contraseña, String hashAlmacenado, String salt)
    {
        try
        {
            // Combinar la contraseña proporcionada con el salt almacenado en la base de datos
            String passwordWithSalt = contraseña + salt;

            // Obtener una instancia de MessageDigest
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Aplicar el hash a la combinación de contraseña y sal
            byte[] hashedBytes = md.digest(passwordWithSalt.getBytes());

            // Convertir el resultado a una representación en base64
            String hashedPassword = Base64.getEncoder().encodeToString(hashedBytes);

            // Comparar el hash calculado con el hash almacenado
            return hashedPassword.equals(hashAlmacenado);

        } catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    private boolean verificarCredenciales(String usuario, String contraseña)
    {
        boolean autenticado = false;
        try ( Session session = Admin_HibernateUtilPostgr.getSessionFactory().openSession())
        {
            String hql = "FROM Usuario WHERE nickname = :nickname";
            Query<Usuario> query = session.createQuery(hql);
            query.setParameter("nickname", usuario);

            Usuario usuarioEncontrado = query.uniqueResult();

            if (usuarioEncontrado != null)
            {
                if (verificarContraseña(contraseña, usuarioEncontrado.getHashContraseña(), usuarioEncontrado.getSalt()))
                {
                    autenticado = true;
                }
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return autenticado;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }
}
