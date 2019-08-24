/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

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
    public List<Software> findSWNoAsignado(SoftwareComponente swComponente) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Software> cq =  cb.createQuery(Software.class);
        Subquery sub = cq.subquery(Software.class);
        Root<Software> sw = cq.from(Software.class);
        Root<Software> subSW = cq.from(Software.class);
        sub.where(cb.equal(sw.get("idSoftware"), swComponente.getIdSoftware()));
        // estas dos
        CriteriaQuery<SoftwareComponente> cqSwC =  cb.createQuery(SoftwareComponente.class);
       Root<SoftwareComponente> swC = cqSwC.from(SoftwareComponente.class);
       //
        Predicate condiciones = cb.and(cb.in(sub).not());
        cq.select(sw);
        cq.where(condiciones);
        
        return em.createQuery(cq).getResultList();
    }
    
}
