/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import Entidades.ActividadTuristica;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author diani
 */
@Stateless
public class ActividadTuristicaFacade extends AbstractFacade<ActividadTuristica> implements ActividadTuristicaFacadeLocal {

    @PersistenceContext(unitName = "GRUPO4_PRN315PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActividadTuristicaFacade() {
        super(ActividadTuristica.class);
    }
    
}
