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
import juan.practica.daw.persistence.validation.UserValidation;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author juald
 */
@WebServlet(name = "UsuarioController", urlPatterns =
{
    "/usuarios/*"
})
public class UsuarioController extends HttpServlet
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String accion;
        accion = request.getPathInfo();
        String vista = null;
        System.out.println(accion);

        switch (accion)
        {
            case "/SaveUser":
            {
                Session session = Admin_HibernateUtilPostgr.getSessionFactory().openSession();
                Transaction transaction = session.beginTransaction();

                //Leer y asignar los campos del formulario a un usuario
                String nombre = request.getParameter("nombre");
                String apellidos = request.getParameter("apellidos");
                String email = request.getParameter("email");
                String nickName = request.getParameter("usuario");

                UsuarioDAO usuarioDAO = new UsuarioDAO(session);
                if (!UserValidation.validarNombre(nombre))
                {

                } else if (!UserValidation.validarApellidos(apellidos))
                {

                } else if (!UserValidation.validarEmail(email))
                {

                } else if (!UserValidation.validarNickName(nickName))
                {

                } else
                {
                    Usuario user = new Usuario(nombre, apellidos, email, nickName);
                    usuarioDAO.save(user);
                    transaction.commit();
                }
                session.close();
                vista = "/jsp/CrearCuenta.jsp";
                break;
            }
            case "/DeleteUser":
            {
                //vista = "/jsp/ShowAllUsers";
                break;
            }
            case "/UpdateUser":
            {
                //vista = "/jsp/CrearCuenta.jsp";
                break;
            }
            case "/IniciarSesion":
            {
                vista = "/jsp/InicioSesion.jsp";
                break;
            }
            default:
                vista = "/jsp/InicioSesion.jsp";
                break;
        }

        RequestDispatcher rd = request.getRequestDispatcher(vista);
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }
}
