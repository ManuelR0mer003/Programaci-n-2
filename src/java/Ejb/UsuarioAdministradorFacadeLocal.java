/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import Entidades.UsuarioAdministrador;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diani
 */
@Local
public interface UsuarioAdministradorFacadeLocal {

    void create(UsuarioAdministrador usuarioAdministrador);

    void edit(UsuarioAdministrador usuarioAdministrador);

    void remove(UsuarioAdministrador usuarioAdministrador);

    UsuarioAdministrador find(Object id);

    List<UsuarioAdministrador> findAll();

    List<UsuarioAdministrador> findRange(int[] range);

    int count();
    
}
