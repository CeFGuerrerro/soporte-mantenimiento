/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Componentes;
import edu.sv.uesocc.entidades.Software;
import edu.sv.uesocc.entidades.SoftwareComponente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

/**
 *
 * @author o-a19
 */
@Stateless
public class SoftwareFacade extends AbstractFacade<Software> implements SoftwareFacadeLocal {

    @PersistenceContext(unitName = "soportePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SoftwareFacade() {
        super(Software.class);
    }
 
   @Override
    public List<Software> findSWNoAsignado(Componentes Componente) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();    //Definicion de la query principal osea
        CriteriaQuery<Software> cq = cb.createQuery(Software.class);    // Select * from software
        Root<Software> sw = cq.from(Software.class);
        cq.select(sw);
        
        Subquery<SoftwareComponente> subq = cq.subquery(SoftwareComponente.class);  // Definicion de la subquery osea
        Root<SoftwareComponente> subSwc = subq.from(SoftwareComponente.class);     // Select * from softwareComponente
        subq.select(subSwc);
        
       // Predicate p = cb.and(cb.equal(subSwc.get("idSoftware"), swComponente.getIdSoftware()),cb.equal(subSwc.get("idSoftware"), sw));
      //Condiciones de la subquery osea WHERE idSoftware = swComponente.idSoftware
        
        Predicate p = cb.and(cb.equal(subSwc.get("idSoftware"), sw), cb.equal(subSwc.get("idComponente"), Componente));
        subq.where(p); // Pasamos las condiciones a la subquery
        cq.where(cb.not(cb.exists(subq))); // Pasamos la subquery a la query principal osea NOT IN (subquery)
        
        return em.createQuery(cq).getResultList(); 
    }
   
}
