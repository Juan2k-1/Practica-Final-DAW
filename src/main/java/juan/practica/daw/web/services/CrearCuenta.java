package juan.practica.daw.web.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import juan.practica.daw.persistence.Admin_HibernateUtilPostgr;
import juan.practica.daw.models.Usuario;
import juan.practica.daw.persistence.dao.UsuarioDAO;
import juan.practica.daw.persistence.validation.UserValidation;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author juald
 */
@WebServlet(name = "CrearCuenta", urlPatterns =
{
    "/CrearCuenta"
})
public class CrearCuenta extends HttpServlet
{

    //@Resource(name = "connectionPool")
    //private DataSource javaBuenaVidaAppPool;
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
        try
        {
            //Establecer la conexión 
            Session session = Admin_HibernateUtilPostgr.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();

            //Leer y asignar los campos del formulario a un usuario
            //String id = request.getParameter("id");
            //long id_user = Long.parseLong(id);
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

        } catch (NumberFormatException ex)
        {
            Logger.getLogger(CrearCuenta.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }

        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CrearCuenta</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CrearCuenta at " + request.getContextPath() + "</h1>");
            out.println("<h2>Estado de la inserción</h2>");
            //out.println(message);
            out.println("<p><a href=\"index.html\">Volver</a></p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    private static final Logger LOG = Logger.getLogger(CrearCuenta.class.getName());

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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
