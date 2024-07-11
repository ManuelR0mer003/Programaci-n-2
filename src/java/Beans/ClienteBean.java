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

import Entidades.Cliente;
import Ejb.ClienteFacadeLocal;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;

@ManagedBean
public class ClienteBean {
    
    @Inject
    private ClienteFacadeLocal clienteFacadeLocal;
    private Cliente cliente;
    private List<Cliente> clientes;
    

    @PostConstruct
    public void init() {
        // inicializamos 
        cliente = new Cliente();
        
        // si estamos editando obtenemos el etiquetaId
        String clienteIdParam = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap().get("cliente_id");
        if (clienteIdParam != null) {
            Long clienteId = Long.parseLong(clienteIdParam);
            cliente = clienteFacadeLocal.find(clienteId);
        }
        
        this.clientes = clienteFacadeLocal.findAll();
    }
    
    // Permite crear un registro
    public void create() throws IOException {
        clienteFacadeLocal.create(cliente);
        FacesContext.getCurrentInstance()
                .getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage("Registro creado."));
        FacesContext.getCurrentInstance()
                .getExternalContext().redirect("indexCliente.xhtml");
    }
    
    // Permite editar un registro
    public void edit() throws IOException {
        clienteFacadeLocal.edit(cliente);
        FacesContext.getCurrentInstance()
                .getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage("Registro actualizado."));
        FacesContext.getCurrentInstance()
                .getExternalContext().redirect("indexCliente.xhtml");
    }
    
    // Permite borrar un registro
    public void delete() throws IOException {
        clienteFacadeLocal.remove(cliente);
        FacesContext.getCurrentInstance()
                .getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage("Registro eliminado."));
        FacesContext.getCurrentInstance()
                .getExternalContext().redirect("indexCliente.xhtml");
    }

    /**
     * @return 
     */
    public List<Cliente> getClientes() {
        return clientes;
    }

    /**
     * @return 
     */
    public Cliente getCliente() {
        return cliente;
    }
}
