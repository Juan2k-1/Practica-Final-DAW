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
     * @param session
     */
    public UsuarioDAO(Session session)
    {
        this.session = session;
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
     * @param email
     * @return
     */
    public Usuario findByEmail(String email)
    {
        /*Query consulta = this.session.createNativeQuery("SELECT * FROM USUARIO U WHERE U.email = :email", Usuario.class);
        consulta.setParameter("email", email);
        Transaction transaction = this.session.beginTransaction();
        Usuario usuario = (Usuario) consulta.getSingleResult();
        transaction.commit();
        return usuario;*/
  
        Usuario usuario = null;
        try
        {
            Query<Usuario> query = this.session.createQuery("FROM Usuario WHERE email = :email", Usuario.class);
            query.setParameter("email", email);
            usuario = query.uniqueResult();
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            if (session != null && session.isOpen())
            {
                session.close();
            }
        }
        return usuario;
    }

    /**
     *
     * @param nickName
     * @return
     */
    public Usuario findByNickName(String nickName)
    {
        /*Query consulta = this.session.createNativeQuery("SELECT * FROM USUARIO U WHERE U.nickname = :nickName", Usuario.class);
        consulta.setParameter("nickName", nickName);
        Transaction transaction = this.session.beginTransaction();
        Usuario usuario = (Usuario) consulta.getSingleResult();
        transaction.commit();
        return usuario;*/
        
        Usuario usuario = null;
        try
        {
            Query<Usuario> query = this.session.createQuery("FROM Usuario WHERE nickname = :nickName", Usuario.class);
            query.setParameter("nickName", nickName);
            usuario = query.uniqueResult();
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            if (session != null && session.isOpen())
            {
                session.close();
            }
        }
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
