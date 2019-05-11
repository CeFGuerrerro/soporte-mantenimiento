/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.ProcesadorComponente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Gaby
 */
@Stateless
public class ProcesadorComponenteFacade extends AbstractFacade<ProcesadorComponente> implements ProcesadorComponenteFacadeLocal {

    @PersistenceContext(unitName = "soportePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProcesadorComponenteFacade() {
        super(ProcesadorComponente.class);
    }
    
}
