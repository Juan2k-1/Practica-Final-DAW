package juan.practica.daw.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
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
@Table(name = "vuelo")
public class Vuelo implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "hora_llegada", nullable = false)
    private LocalTime horaLlegada;

    @Column(name = "hora_salida", nullable = false)
    private LocalTime horaSalida;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "puertaDeEmbarque", nullable = false)
    private String puertaDeEmbarque;

    @Column(name = "ciudad_origen", nullable = false)
    private String ciudadOrigen;

    @Column(name = "ciudad_destino", nullable = false)
    private String ciudadDestino;

    /**
     *
     */
    public Vuelo()
    {
    }

    /**
     *
     * @param id
     * @param fecha
     * @param horaLlegada
     * @param horaSalida
     * @param estado
     * @param puertaDeEmbarque
     * @param ciudadOrigen
     * @param ciudadDestino
     */
    public Vuelo(long id, LocalDate fecha, LocalTime horaLlegada, LocalTime horaSalida, String estado, String puertaDeEmbarque, String ciudadOrigen, String ciudadDestino)
    {
        this.id = id;
        this.fecha = fecha;
        this.horaLlegada = horaLlegada;
        this.horaSalida = horaSalida;
        this.estado = estado;
        this.puertaDeEmbarque = puertaDeEmbarque;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
    }

    /**
     *
     * @return
     */
    public long getId()
    {
        return id;
    }

    /**
     *
     * @return
     */
    public LocalDate getFecha()
    {
        return fecha;
    }

    /**
     *
     * @return
     */
    public LocalTime getHoraLlegada()
    {
        return horaLlegada;
    }

    /**
     *
     * @return
     */
    public LocalTime getHoraSalida()
    {
        return horaSalida;
    }

    /**
     *
     * @return
     */
    public String getEstado()
    {
        return estado;
    }

    /**
     *
     * @return
     */
    public String getPuertaDeEmbarque()
    {
        return puertaDeEmbarque;
    }

    /**
     *
     * @return
     */
    public String getCiudadOrigen()
    {
        return ciudadOrigen;
    }

    /**
     *
     * @return
     */
    public String getCiudadDestino()
    {
        return ciudadDestino;
    }

    /**
     *
     * @param fecha
     */
    public void setFecha(LocalDate fecha)
    {
        this.fecha = fecha;
    }

    /**
     *
     * @param horaLlegada
     */
    public void setHoraLlegada(LocalTime horaLlegada)
    {
        this.horaLlegada = horaLlegada;
    }

    /**
     *
     * @param horaSalida
     */
    public void setHoraSalida(LocalTime horaSalida)
    {
        this.horaSalida = horaSalida;
    }

    /**
     *
     * @param estado
     */
    public void setEstado(String estado)
    {
        this.estado = estado;
    }

    /**
     *
     * @param puertaDeEmbarque
     */
    public void setPuertaDeEmbarque(String puertaDeEmbarque)
    {
        this.puertaDeEmbarque = puertaDeEmbarque;
    }

    /**
     *
     * @param ciudadOrigen
     */
    public void setCiudadOrigen(String ciudadOrigen)
    {
        this.ciudadOrigen = ciudadOrigen;
    }

    /**
     *
     * @param ciudadDestino
     */
    public void setCiudadDestino(String ciudadDestino)
    {
        this.ciudadDestino = ciudadDestino;
    }
}