package juan.practica.daw.persistence.dao;

import java.util.ArrayList;
import juan.practica.daw.models.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Juan Alberto Dominguez Vazquez
 */
public class UsuarioDAO
{

    private final Session session;

    /**
     *
     * @param sessionFactory
     */
    public UsuarioDAO(Session sessionFactory)
    {
        this.session = sessionFactory;
    }

    /**
     *
     * @param usuario
     */
    public void save(Usuario usuario)
    {
        Transaction transaction = session.beginTransaction();
        try
        {
            session.save(usuario);
            transaction.commit();
        } catch (Exception e)
        {
            //this.vMensaje.MensajeDeError("Error al insertar un usuario", e.getMessage());
            transaction.rollback();
        }
    }

    /**
     *
     * @param usuario
     */
    public void update(Usuario usuario)
    {
        Transaction transaction = session.beginTransaction();
        try
        {
            session.update(usuario);
            transaction.commit();
        } catch (Exception e)
        {
            //this.vMensaje.MensajeDeError("Error al insertar un usuario", e.getMessage());
            transaction.rollback();
        }
    }

    /**
     *
     * @param usuario
     */
    public void delete(Usuario usuario)
    {
        Transaction transaction = session.beginTransaction();
        try
        {
            session.delete(usuario);
            transaction.commit();
        } catch (Exception e)
        {
            //this.vMensaje.MensajeDeError("Error al insertar un usuario", e.getMessage());
            transaction.rollback();
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public Usuario findById(long id)
    {
        Query consulta = this.session.createNativeQuery("SELECT * FROM USUARIO U WHERE U.id =: id", Usuario.class);
        Transaction transaction = this.session.beginTransaction();
        Usuario usuario = (Usuario) consulta.getSingleResult();
        transaction.commit();
        return usuario;
    }

    /**
     *
     * @param id
     * @return
     */
    public ArrayList<Usuario> findAll(long id)
    {
        Query consulta = this.session.createNativeQuery("SELECT * FROM USUARIO", Usuario.class);
        Transaction transaction = this.session.beginTransaction();
        ArrayList<Usuario> usuarios = (ArrayList<Usuario>) consulta.getResultList();
        transaction.commit();
        return usuarios;
    }
}
