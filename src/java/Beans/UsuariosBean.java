package Beans;

import Ejb.UsuarioAdministradorFacadeLocal;
import Entidades.UsuarioAdministrador;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;

@ManagedBean
public class UsuariosBean {
    
    @Inject
    private UsuarioAdministradorFacadeLocal usuarioAdministradorFacadeLocal;
    private UsuarioAdministrador usuarioAdministrador;
    private List<UsuarioAdministrador> usuariosAdministradores;
    
    @PostConstruct
    public void init() {
        // inicializamos 
        usuarioAdministrador = new UsuarioAdministrador();
        
        String usuarioAdministradorIdParam = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap().get("usuario_id");
        if (usuarioAdministradorIdParam != null) {
            Long usuarioId = Long.parseLong(usuarioAdministradorIdParam);
            usuarioAdministrador = usuarioAdministradorFacadeLocal.find(usuarioId);
        }
        
        this.usuariosAdministradores = usuarioAdministradorFacadeLocal.findAll();
    }
    
    // Permite crear un registro
    public void create() throws IOException {
        usuarioAdministradorFacadeLocal.create(usuarioAdministrador);
        FacesContext.getCurrentInstance()
                .getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage("Registro creado."));
        FacesContext.getCurrentInstance()
                .getExternalContext().redirect("IndexUsuarios.xhtml");
    }
    
    // Permite editar un registro
    public void edit() throws IOException {
        usuarioAdministradorFacadeLocal.edit(usuarioAdministrador);
        FacesContext.getCurrentInstance()
                .getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage("Registro actualizado."));
        FacesContext.getCurrentInstance()
                .getExternalContext().redirect("IndexUsuarios.xhtml");
    }
    
    // Permite borrar un registro
    public void delete() throws IOException {
        usuarioAdministradorFacadeLocal.remove(usuarioAdministrador);
        FacesContext.getCurrentInstance()
                .getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage("Registro eliminado."));
        FacesContext.getCurrentInstance()
                .getExternalContext().redirect("IndexUsuarios.xhtml");
    }

    /**
     * @return 
     */
    public List<UsuarioAdministrador> getUsuarioAdministrador() {
        return usuariosAdministradores;
    }

    /**
     * @return 
     */
    public UsuarioAdministrador getUsuario() {
        return usuarioAdministrador;
    }
     
}

