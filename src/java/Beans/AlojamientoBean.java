package Beans;

/**
 *
 * @author Alexander
 */

import Ejb.AlojamientoFacadeLocal;
import Entidades.Alojamiento;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;


@ManagedBean
public class AlojamientoBean {
        @Inject
    private AlojamientoFacadeLocal alojamientoFacadeLocal;
    private Alojamiento alojamiento;
    private List<Alojamiento> alojamientos;
    
    @PostConstruct
    
    public void init(){
        alojamiento = new Alojamiento();
        
        String alojamientoIdParam = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap().get("alojamiento_id");
        if (alojamientoIdParam != null) {
            Long alojamientoId = Long.parseLong(alojamientoIdParam);
            alojamiento = alojamientoFacadeLocal.find(alojamientoId);
        }
        
        this.alojamientos = alojamientoFacadeLocal.findAll();
    }
    
           // Permite crear un registro
    public void create() throws IOException {
        alojamientoFacadeLocal.create(alojamiento);
        FacesContext.getCurrentInstance()
                .getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage("Registro creado."));
        FacesContext.getCurrentInstance()
                .getExternalContext().redirect("indexAlojamiento.xhtml");
    }
    
      // Permite editar un registro
    public void edit() throws IOException {
        alojamientoFacadeLocal.edit(alojamiento);
        FacesContext.getCurrentInstance()
                .getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage("Registro actualizado."));
        FacesContext.getCurrentInstance()
                .getExternalContext().redirect("indexAlojamiento.xhtml");
    }
    
         // Permite eliminar un registro
   public void delete() throws IOException {
        alojamientoFacadeLocal.remove(alojamiento);
        FacesContext.getCurrentInstance()
                .getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage("Registro eliminado."));
        FacesContext.getCurrentInstance()
                .getExternalContext().redirect("indexAlojamiento.xhtml");
    }

    /**
     * @return 
     */
    public Alojamiento getAlojamiento() {
        return alojamiento;
    }
    
    /**
     * @return 
     */
    public List<Alojamiento> getAlojamientos() {
        return alojamientos;
    }
    
    
 }


