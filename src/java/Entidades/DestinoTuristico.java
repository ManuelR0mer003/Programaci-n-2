package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Alexander
 */

@Entity
@Table (name = "DestinoTuristico")
public class DestinoTuristico implements Serializable {

    @Id
    @Column(name = "destinoTuristico_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long destinoTuristicoId;
     @Basic(optional = false)
    
    @NotNull
    @Size(min=1,max=100)
    @Column(name="nombre")
    private String nombre;
    
    @NotNull
    @Size(min=1,max=100)
    @Column(name="descripcion")
    private String descripcion;

    public DestinoTuristico() {
    }

    public DestinoTuristico(long destinoTuristicoId, String nombre, String descripcion) {
        this.destinoTuristicoId = destinoTuristicoId;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    

    public long getDestinoTuristicoId() {
        return destinoTuristicoId;
    }

    public void setDestinoTuristicoId(long destinoTuristicoId) {
        this.destinoTuristicoId = destinoTuristicoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
   
}

