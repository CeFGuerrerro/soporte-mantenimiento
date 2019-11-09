/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Componentes;
import edu.sv.uesocc.entidades.SoftwareComponente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
//import edu.sv.uesocc.entidades.Componentes;

/**
 *
 * @author o-a19
 */
@Stateless
public class SoftwareComponenteFacade extends AbstractFacade<SoftwareComponente> implements SoftwareComponenteFacadeLocal {

    @PersistenceContext(unitName = "soportePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SoftwareComponenteFacade() {
        super(SoftwareComponente.class);
    }

    @Override
    public List<SoftwareComponente> buscarSoftware(Componentes componentes) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<SoftwareComponente> cq = cb.createQuery(SoftwareComponente.class);
        Root<SoftwareComponente> comp = cq.from(SoftwareComponente.class);
        Predicate condi = cb.and(cb.equal(comp.get("idComponente"), componentes));
        cq.select(comp);     
        cq.where(condi);
        
        return em.createQuery(cq).getResultList();
    }
    
    
    
}
