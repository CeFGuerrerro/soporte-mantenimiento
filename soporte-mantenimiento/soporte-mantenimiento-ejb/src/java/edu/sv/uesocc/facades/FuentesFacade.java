/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Fuentes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author o-a19
 */
@Stateless
public class FuentesFacade extends AbstractFacade<Fuentes> implements FuentesFacadeLocal {

    @PersistenceContext(unitName = "soportePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FuentesFacade() {
        super(Fuentes.class);
    }
    
}
