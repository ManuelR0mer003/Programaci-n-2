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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Miguel Hz
 */
@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable {
    
    @Id
    @Column(name = "cliente_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long clienteId;
    @Basic(optional = false)
    
    @NotNull
    @Size(min=1,max=100)
    @Column(name="apellidos")
    private String apellidos;
    
    @NotNull
    @Size(min=1,max=100)
    @Column(name="correoElectronico")
    private String correoElectronico;
    
    @NotNull
    @Size(min=1,max=10)
    @Column(name="identificacion")
    private String identificacion;
    
    @NotNull
    @Size(min=1,max=100)
    @Column(name="nombres")
    private String nombres;
    
    @NotNull
    @Size(min=1,max=9)
    @Column(name="numeroTelefonico")
    private String numeroTelefonico;

    public Cliente() {
    }

    public Cliente(long clienteId, String apellidos, String correoElectronico, String identificacion, String nombres, String numeroTelefonico) {
        this.clienteId = clienteId;
        this.apellidos = apellidos;
        this.correoElectronico = correoElectronico;
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.numeroTelefonico = numeroTelefonico;
    }

    public long getClienteId() {
        return clienteId;
    }

    public void setClienteId(long clienteId) {
        this.clienteId = clienteId;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }
    
}
