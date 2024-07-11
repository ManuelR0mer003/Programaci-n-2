package Entidades;

/**
 *
 * @author Alexander
 */

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name = "Alojamiento")

    public class Alojamiento implements Serializable{
    
    @Id
    @Column(name = "alojamiento_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long alojamientoId;
    @Basic(optional = false)
    
    @NotNull
    @Size(min=1,max=100)
    @Column(name="nombreHotel")
    private String nombreHotel;
    
    @NotNull
    @Size(min=1,max=100)
    @Column(name="habitacionesRequeridas")
    private String habitacionesRequeridas;
    
    @NotNull
    @Min(value = 0, message = "El precio debe ser mayor o igual que 0")
    @Column(name="precioHabitacion")
    private Double precioHabitacion;
    
    @NotNull
    @Size(min=1,max=100)
    @Column(name="tipoHabitacion")
    private String tipoHabitacion;
    
    public Alojamiento() {
    }
    
    public Alojamiento(long alojamientoId, String nombreHotel, String habitacionesRequeridas, Double precioHabitacion, String tipoHabitacion) {
        this.alojamientoId = alojamientoId;
        this.nombreHotel = nombreHotel;
        this.habitacionesRequeridas = habitacionesRequeridas;
        this.precioHabitacion = precioHabitacion;
        this.tipoHabitacion = tipoHabitacion;
    }
    
    
    public long getAlojamientoId() {
        return alojamientoId;
    }

    public void setAlojamientoId(long alojamientoId) {
        this.alojamientoId = alojamientoId;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public String getHabitacionesRequeridas() {
        return habitacionesRequeridas;
    }

    public void setHabitacionesRequeridas(String habitacionesRequeridas) {
        this.habitacionesRequeridas = habitacionesRequeridas;
    }

    public Double getPrecioHabitacion() {
        return precioHabitacion;
    }

    public void setPrecioHabitacion(Double precioHabitacion) {
        this.precioHabitacion = precioHabitacion;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

}
