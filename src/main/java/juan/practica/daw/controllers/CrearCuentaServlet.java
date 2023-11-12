package juan.practica.daw.controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.hibernate.Session;
import org.hibernate.Transaction;

@WebServlet(name = "CrearCuentaServlet", urlPatterns =
{
    "/Usuarios/*"
})
public class CrearCuentaServlet extends HttpServlet
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String accion;
        accion = request.getPathInfo();
        String vista = null;

        System.out.println(accion);
        switch (accion)
        {
            case "/CrearCuenta":
            {
                String nombre = request.getParameter("nombre");
                String apellidos = request.getParameter("apellidos");
                String email = request.getParameter("email");
                String nickName = request.getParameter("usuario");
                String contraseña = request.getParameter("password");
                String repitContraseña = request.getParameter("repit_password");

                if (validarNombre(nombre) && validarApellidos(apellidos) && validarContraseña(contraseña)
                        && validarRepitContraseña(repitContraseña) && validarEmail(email)
                        && validarNickName(nickName))
                {
                    if (esNicknameUnico(nickName) && esEmailUnico(email))
                    {
                        Usuario user = new Usuario(nombre, apellidos, email, nickName);
                        registrarEnBD(user);
                        vista = "/jsp/RegistroExitoso.jsp";
                    } else
                    {
                        vista = "/jsp/RegistroFallido.jsp";
                    }
                } else
                {
                    vista = "/jsp/RegistroFallido.jsp";
                }
                break;
            }
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
        try
        {
            session = Admin_HibernateUtilPostgr.getSessionFactory().openSession();
            UsuarioDAO usuarioDAO = new UsuarioDAO(session);
            Usuario usuarioExistente = usuarioDAO.findByNickName(nickName);

            if (usuarioExistente == null)
            {
                resultado = true;  
            } else
            {
                resultado = false;  
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
            Usuario usuarioExistente = usuarioDAO.findByEmail(email);

            if (usuarioExistente == null)
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
