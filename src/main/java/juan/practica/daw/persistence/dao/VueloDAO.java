package juan.practica.daw.persistence.dao;

import java.util.ArrayList;
import juan.practica.daw.models.Vuelo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Juan Alberto Dominguez Vazquez
 */
public class VueloDAO
{
    private final Session session;

    /**
     *
     * @param session
     */
    public VueloDAO(Session session)
    {
        this.session = session;
    }

    /**
     *
     * @param vuelo
     */
    public void save(Vuelo vuelo)
    {
        Transaction transaction = session.beginTransaction();
        try
        {
            session.save(vuelo);
            transaction.commit();
        } catch (Exception e)
        {
            //this.vMensaje.MensajeDeError("Error al insertar un usuario", e.getMessage());
            transaction.rollback();
        }
    }

    /**
     *
     * @param vuelo
     */
    public void update(Vuelo vuelo)
    {
        Transaction transaction = session.beginTransaction();
        try
        {
            session.update(vuelo);
            transaction.commit();
        } catch (Exception e)
        {
            transaction.rollback();
        }
    }

    /**
     *
     * @param vuelo
     */
    public void delete(Vuelo vuelo)
    {
        Transaction transaction = session.beginTransaction();
        try
        {
            session.delete(vuelo);
            transaction.commit();
        } catch (Exception e)
        {
            transaction.rollback();
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public Vuelo findById(long id)
    {
        Query consulta = this.session.createNativeQuery("SELECT * FROM VUELO V WHERE V.id =: id", Vuelo.class);
        Transaction transaction = this.session.beginTransaction();
        Vuelo vuelo = (Vuelo) consulta.getSingleResult();
        transaction.commit();
        return vuelo;
    }

    /**
     *
     * @param id
     * @return
     */
    public ArrayList<Vuelo> findAll(long id)
    {
        Query consulta = this.session.createNativeQuery("SELECT * FROM VUELO", Vuelo.class);
        Transaction transaction = this.session.beginTransaction();
        ArrayList<Vuelo> vuelos = (ArrayList<Vuelo>) consulta.getResultList();
        transaction.commit();
        return vuelos;
    }
}