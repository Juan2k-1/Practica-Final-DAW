package juan.practica.daw.controllers;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import juan.practica.daw.models.Vuelo;
import juan.practica.daw.persistence.User_HibernateUtilPostgr;
import juan.practica.daw.persistence.dao.VueloDAO;
import org.hibernate.Session;

/**
 *
 * @author juald
 */
@WebServlet(name = "VueloController", urlPatterns =
{
    "/Vuelos/*"
})
public class VueloController extends HttpServlet
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

        switch (accion)
        {
            case "/MostrarVuelos/":
            {
                String origen = request.getParameter("origen");
                String destino = request.getParameter("destino");

                ArrayList<Vuelo> vuelos = buscarVuelos(origen, destino);
                if (vuelos == null)
                {
                    vista = "/jsp/NoFlights.jsp";
                } else
                {
                    request.setAttribute("listaDeVuelos", vuelos);
                    vista = "/jsp/ShowSelectedFlights.jsp";
                }
                break;
            }
            case "/MostrarVuelos/SeleccionarVuelo/":
            {
                String id = request.getParameter("vuelo");
                if (id != null)
                {
                    long idVuelo = Long.parseLong(id);
                    Vuelo vueloSeleccionado = buscarVueloPorID(idVuelo);

                    request.setAttribute("vueloSeleccionado", vueloSeleccionado);

                    vista = "/jsp/vuelosSeleccionados.jsp";
                }
                break;
            }
            case "/MostrarVuelos/SeleccionarVuelo/ComprarBilletes/":
            {
                HttpSession session = request.getSession(false);
                if (session != null && session.getAttribute("usuario") != null)
                {
                    // El usuario ha iniciado sesión, realiza las acciones necesarias
                        vista = "/jsp/ComprarBilletes.jsp";
                } else
                {
                    // El usuario no ha iniciado sesión, redirige a la página de inicio de sesión
                    request.setAttribute("mensajeError", "Debes iniciar sesión antes de comprar billetes.");
                    vista = "/home/IniciarSesion/";
                }             
                break;
            }
            case "/MostrarVuelos/SeleccionarVuelo/ProcesarCompra/":
            {
                // Recuperar los parámetros del formulario
                int cantidadBilletes = Integer.parseInt(request.getParameter("cantidadBilletes"));
                String tipoBillete = request.getParameter("tipoBillete");

                // Verificar la disponibilidad de plazas
                int plazasDisponibles = 200;
                if (cantidadBilletes > plazasDisponibles)
                {
                    enviarMensajeError(request, response, "Error, ha seleccionado más plazas de las disponibles.");
                }

                // Calcular el precio total según el tipo de billete
                double precioPorPersona = 0;
                switch (tipoBillete)
                {
                    case "PrimeraClase":
                        precioPorPersona = 50;
                        break;
                    case "Business":
                        precioPorPersona = 25;
                        break;
                    case "Turista":
                        precioPorPersona = 15;
                        break;
                    default:
                        enviarMensajeError(request, response, "Error, tipo de billete no válido.");
                        break;
                }

                double precioTotal = cantidadBilletes * precioPorPersona;
                request.setAttribute("cantidadBilletes", cantidadBilletes);
                request.setAttribute("tipoBillete", tipoBillete);
                request.setAttribute("precioTotal", precioTotal);
                vista = "/jsp/ResumenCompra.jsp";
                break;
            }
            default:
                vista = "/jsp/index.jsp";
                break;
        }
        System.out.println(vista);
        RequestDispatcher rd = request.getRequestDispatcher(vista);
        rd.forward(request, response);
    }

    private void enviarMensajeError(HttpServletRequest request, HttpServletResponse response, String mensaje) throws ServletException, IOException
    {
        request.setAttribute("mensajeError", mensaje);

        // Y redirigir a la página de confirmación mostrando el mensaje de error
        RequestDispatcher rd = request.getRequestDispatcher("/jsp/ConfirmacionCompra.jsp");
        rd.forward(request, response);
    }

    private ArrayList<Vuelo> buscarVuelos(String origen, String destino)
    {
        Session session = User_HibernateUtilPostgr.getSessionFactory().openSession();
        VueloDAO vueloDAO = new VueloDAO(session);
        ArrayList<Vuelo> vuelos = vueloDAO.findFlights(origen, destino);
        return vuelos;
    }

    private Vuelo buscarVueloPorID(Long id)
    {
        Session session = User_HibernateUtilPostgr.getSessionFactory().openSession();
        VueloDAO vueloDAO = new VueloDAO(session);
        Vuelo vuelo = vueloDAO.findById(id);
        return vuelo;
    }

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
