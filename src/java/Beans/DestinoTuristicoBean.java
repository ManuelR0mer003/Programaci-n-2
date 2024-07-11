package Beans;

/**
 *
 * @author Alexander
 */
import Entidades.DestinoTuristico;
import Ejb.DestinoTuristicoFacadeLocal;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;

@ManagedBean
public class DestinoTuristicoBean {
    
    @Inject
    private DestinoTuristicoFacadeLocal destinoTuristicoFacadeLocal;
    private DestinoTuristico destinoTuristico;
    private List<DestinoTuristico> destinoTuristicos;
    
        @PostConstruct
    public void init() {

        destinoTuristico = new DestinoTuristico();
        
        String destinoTuristicoIdParam = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap().get("destinoTuristico_id");
        if (destinoTuristicoIdParam != null) {
            Long destinoTuristicoId = Long.parseLong(destinoTuristicoIdParam);
            destinoTuristico = destinoTuristicoFacadeLocal.find(destinoTuristicoId);
        }
        
        this.destinoTuristicos = destinoTuristicoFacadeLocal.findAll();
    }
    
        // Permite crear un registro
    public void create() throws IOException {
        destinoTuristicoFacadeLocal.create(destinoTuristico);
        FacesContext.getCurrentInstance()
                .getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage("Registro creado."));
        FacesContext.getCurrentInstance()
                .getExternalContext().redirect("IndexDestinoTuristico.xhtml");
    }
    
        // Permite editar un registro
    public void edit() throws IOException {
        destinoTuristicoFacadeLocal.edit(destinoTuristico);
        FacesContext.getCurrentInstance()
                .getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage("Registro actualizado."));
        FacesContext.getCurrentInstance()
                .getExternalContext().redirect("IndexDestinoTuristico.xhtml");
    }
    
       // Permite borrar un registro
    
    public void delete() throws IOException {
        destinoTuristicoFacadeLocal.remove(destinoTuristico);
        FacesContext.getCurrentInstance()
                .getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage("Registro eliminado."));
        FacesContext.getCurrentInstance()
                .getExternalContext().redirect("IndexDestinoTuristico.xhtml");
    }


public List<DestinoTuristico> getDestinoTuristicos(){
    return destinoTuristicos;
}

public DestinoTuristico getDestinoTuristico() {
    return destinoTuristico;
}
    
}

