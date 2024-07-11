/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

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

/**
 *
 * @author Miguel Hernández
 */

@Entity
@Table(name = "ActividadTuristica")
public class ActividadTuristica implements Serializable {
    
    @Id
    @Column(name = "actividadTuristica_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long actividadTuristicaId;
    @Basic(optional = false)
    
    @NotNull
    @Size(min=1,max=100)
    @Column(name="nombreActividad")
    private String nombreActividad;
    
    @NotNull
    @Size(min=1,max=100)
    @Column(name="descripcion")
    private String descripcion;
      
    @NotNull
    @Min(value = 0, message = "El precio debe ser mayor o igual que 0")
    @Column(name="precio")
    private Double precio;

    public ActividadTuristica() {
    }

    public ActividadTuristica(long actividadTuristicaId, String nombreActividad, String descripcion, Double precio) {
        this.actividadTuristicaId = actividadTuristicaId;
        this.descripcion = descripcion;
        this.nombreActividad = nombreActividad;
        this.precio = precio;
    }

    public long getActividadTuristicaId() {
        return actividadTuristicaId;
    }

    public void setActividadTuristicaId(long actividadTuristicaId) {
        this.actividadTuristicaId = actividadTuristicaId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    
}
