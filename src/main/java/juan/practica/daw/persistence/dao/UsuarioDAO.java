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
    public boolean findByEmail(String email)
    {
        Usuario usuario = null;
        boolean resultado = false;
        try
        {
            Query<Usuario> query = this.session.createQuery("FROM Usuario WHERE email = :email", Usuario.class);
            query.setParameter("email", email);
            usuario = query.uniqueResult();
            if (usuario == null)
            {
                resultado = true;
            } else
            {
                resultado = false;
            }
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
        return resultado;
    }

    /**
     *
     * @param nickName
     * @return
     */
    public boolean findByNickName(String nickName)
    {
        boolean resultado = false;
        Usuario usuario = null;
        try
        {
            Query<Usuario> query = this.session.createQuery("FROM Usuario WHERE nickName = :nickName", Usuario.class);
            query.setParameter("nickName", nickName);
            usuario = query.uniqueResult();
            if (usuario == null)
            {
                resultado = true;
            } else
            {
                resultado = false;
            }
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
        return resultado;
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
