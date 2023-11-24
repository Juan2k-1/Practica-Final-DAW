package juan.practica.daw.controllers.tests;

import juan.practica.daw.persistence.Admin_HibernateUtilPostgr;
import juan.practica.daw.persistence.dao.UsuarioDAO;
import org.hibernate.Session;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Juan Alberto Dominguez Vazquez
 */
public class PrincipalControllerTest
{

    public PrincipalControllerTest()
    {
    }

    @BeforeAll
    public static void setUpClass()
    {
    }

    @AfterAll
    public static void tearDownClass()
    {
    }

    @BeforeEach
    public void setUp()
    {
    }

    @AfterEach
    public void tearDown()
    {
    }

    /**
     * Test of esEmailUnico method, of class PrincipalController.
     */
    @Test
    public void esEmailUnico() 
    {
        Session session = Admin_HibernateUtilPostgr.getSessionFactory().openSession();
        UsuarioDAO usuarioDAO = new UsuarioDAO(session);
        assertTrue(usuarioDAO.findByEmail("user4@gmail.com"));
    }

    /**
     * Test of esNickNameValido method, of class PrincipalController.
     */
    @Test
    public void esNickNameUnico() 
    {
        Session session = Admin_HibernateUtilPostgr.getSessionFactory().openSession();
        UsuarioDAO usuarioDAO = new UsuarioDAO(session);
        assertTrue(usuarioDAO.findByNickName("User4"));
    }
}