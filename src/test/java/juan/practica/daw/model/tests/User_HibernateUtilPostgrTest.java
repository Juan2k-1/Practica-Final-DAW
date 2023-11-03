package juan.practica.daw.model.tests;

import juan.practica.daw.persistence.User_HibernateUtilPostgr;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author juald
 */
public class User_HibernateUtilPostgrTest
{

    public User_HibernateUtilPostgrTest()
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
     * Test of getSessionFactory method, of class User_HibernateUtilPostgr.
     */
    @Test
    public void testGetSessionFactory()
    {
        SessionFactory userSession = User_HibernateUtilPostgr.getSessionFactory();
        try ( Session session = userSession.openSession())
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