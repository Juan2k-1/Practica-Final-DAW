package juan.practica.daw.web.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import juan.practica.daw.models.Usuario;

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

    @Resource(name = "connectionPool")
    private DataSource javaBuenaVidaAppPool;

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
        String message = null;
        Usuario user;
        Connection connection;
        PreparedStatement ps;
        int filasAfectadas = 0;

        try
        {
            //Establecer la conexión 
            Context c = new InitialContext();
            javaBuenaVidaAppPool = (DataSource) c.lookup("jdbc/myDatasource");
            connection = javaBuenaVidaAppPool.getConnection();

            //Leer y asignar los campos del formulario a un usuario
            //String id = request.getParameter("id");
            //long id_user = Long.parseLong(id);
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            String email = request.getParameter("email");
            String nickName = request.getParameter("usuario");

            user = new Usuario(nombre, apellidos, email, nickName);

            //Preparar la sentencia SQL
            ps = connection.prepareStatement("INSERT INTO USUARIO (NOMBRE, APELLIDOS, EMAIL, NICKNAME) VALUES (?, ?, ?, ?)");
            //ps.setLong(1, user.getId());
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getApellidos());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getNickName());

            //Ejecutar instrucción SQL y guardar resultado en message
            filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0)
            {
                message = "<p>OK: Inserción realizada correctamente</p>";
            } else
            {
                message = "<p>ERROR: Ha fallado la inserción</p>";
            }
            ps.close();
            connection.close();
        } catch (NamingException | SQLException | NumberFormatException ex)
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
            out.println(message);
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
