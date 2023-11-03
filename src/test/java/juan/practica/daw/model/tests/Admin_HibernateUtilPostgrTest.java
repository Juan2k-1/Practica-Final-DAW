package juan.practica.daw.model.tests;

import juan.practica.daw.persistence.Admin_HibernateUtilPostgr;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author juald
 */
public class Admin_HibernateUtilPostgrTest
{

    public Admin_HibernateUtilPostgrTest()
    {
    }

    @BeforeAll
    public static void setUpClass() throws Exception
    {
    }

    @AfterAll
    public static void tearDownClass() throws Exception
    {
    }

    @BeforeEach
    public void setUp() throws Exception
    {
    }

    @AfterEach
    public void tearDown() throws Exception
    {
    }

    /**
     * Test of getSessionFactory method, of class Admin_HibernateUtilPostgr.
     */
    @Test
    public void testGetSessionFactory()
    {
        SessionFactory adminSession = Admin_HibernateUtilPostgr.getSessionFactory();
        try ( Session session = adminSession.openSession())
        {
            session.beginTransaction();

            session.createNativeQuery("SELECT CURRENT_DATE").getResultList().get(0);
            session.close();
        } catch (Exception e)
        {
            fail();
        }
    }
}