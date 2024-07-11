/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import Entidades.DestinoTuristico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diani
 */
@Local
public interface DestinoTuristicoFacadeLocal {

    void create(DestinoTuristico destinoTuristico);

    void edit(DestinoTuristico destinoTuristico);

    void remove(DestinoTuristico destinoTuristico);

    DestinoTuristico find(Object id);

    List<DestinoTuristico> findAll();

    List<DestinoTuristico> findRange(int[] range);

    int count();
    
}
