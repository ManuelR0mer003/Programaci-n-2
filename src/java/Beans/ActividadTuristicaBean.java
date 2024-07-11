/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Miguel Hernández
 */

import Entidades.ActividadTuristica;
import Ejb.ActividadTuristicaFacadeLocal;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;

@ManagedBean
public class ActividadTuristicaBean {
    
    @Inject
    private ActividadTuristicaFacadeLocal actividadTuristicaFacadeLocal;
    private ActividadTuristica actividadTuristica;
    private List<ActividadTuristica> actividadesTuristicas;
    
    @PostConstruct
    public void init() {
        // inicializamos 
        actividadTuristica = new ActividadTuristica();
        
        String actividadTuristicaIdParam = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap().get("actividadTuristica_id");
        if (actividadTuristicaIdParam != null) {
            Long actividadTuristicaId = Long.parseLong(actividadTuristicaIdParam);
            actividadTuristica = actividadTuristicaFacadeLocal.find(actividadTuristicaId);
        }
        
        this.actividadesTuristicas = actividadTuristicaFacadeLocal.findAll();
    }
    
    // Permite crear un registro
    public void create() throws IOException {
        actividadTuristicaFacadeLocal.create(actividadTuristica);
        FacesContext.getCurrentInstance()
                .getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage("Registro creado."));
        FacesContext.getCurrentInstance()
                .getExternalContext().redirect("IndexActividadTuristica.xhtml");
    }
    
    // Permite editar un registro
    public void edit() throws IOException {
        actividadTuristicaFacadeLocal.edit(actividadTuristica);
        FacesContext.getCurrentInstance()
                .getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage("Registro actualizado."));
        FacesContext.getCurrentInstance()
                .getExternalContext().redirect("IndexActividadTuristica.xhtml");
    }
    
    // Permite borrar un registro
    public void delete() throws IOException {
        actividadTuristicaFacadeLocal.remove(actividadTuristica);
        FacesContext.getCurrentInstance()
                .getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage("Registro eliminado."));
        FacesContext.getCurrentInstance()
                .getExternalContext().redirect("IndexActividadTuristica.xhtml");
    }

    /**
     * @return 
     */
    public List<ActividadTuristica> getActividadesTuristicas() {
        return actividadesTuristicas;
    }

    /**
     * @return 
     */
    public ActividadTuristica getActividadTuristica() {
        return actividadTuristica;
    }
    
}
