package juan.practica.daw.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author juald
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "nickName", nullable = false, unique = true)
    private String nickName;

    /**
     *
     */
    public Usuario()
    {
    }

    /**
     *
     * @param nombre
     * @param apellido
     * @param email
     * @param nickName
     */
    public Usuario(Long id, String nombre, String apellido, String email, String nickName)
    {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellido;
        this.email = email;
        this.nickName = nickName;
    }
    
    /**
     *
     * @param nombre
     * @param apellido
     * @param email
     * @param nickName
     */
    public Usuario(String nombre, String apellido, String email, String nickName)
    {
        this.nombre = nombre;
        this.apellidos = apellido;
        this.email = email;
        this.nickName = nickName;
    }

    /**
     *
     * @return
     */
    public Long getId()
    {
        return id;
    }

    /**
     *
     * @return
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     *
     * @return
     */
    public String getApellidos()
    {
        return apellidos;
    }

    /**
     *
     * @return
     */
    public String getEmail()
    {
        return email;
    }

    /**
     *
     * @return
     */
    public String getNickName()
    {
        return nickName;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    /**
     *
     * @param apellidos
     */
    public void setApellidos(String apellidos)
    {
        this.apellidos = apellidos;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     *
     * @param nickName
     */
    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 11 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return this.id == other.id;
    }

    @Override
    public String toString()
    {
        return "juan.practica.daw.models.Usuario[ id=" + id + " ]";
    }
}