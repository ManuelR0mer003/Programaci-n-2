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

@Entity
@Table(name = "UsuarioAdministrador")
public class UsuarioAdministrador implements Serializable {

   @Id
    @Column(name = "usuario_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long usuarioId;
    @Basic(optional = false)
    
    @NotNull
    @Size(min=1,max=255)
    @Column(name="contrasenia")
    private String contrasenia;
    
    @NotNull
    @Size(min=1,max=255)
    @Column(name="usuario")
    private String usuario;

    public UsuarioAdministrador() {
    }

    public UsuarioAdministrador(long usuarioId, String contrasenia, String usuario) {
        this.usuarioId = usuarioId;
        this.contrasenia = contrasenia;
        this.usuario = usuario;
    }

    public long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
    
}
