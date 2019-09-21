/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.ProcesadorComponente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
    
    @Override
    public List<ProcesadorComponente> findAsignados(int id) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<ProcesadorComponente> cq = cb.createQuery(ProcesadorComponente.class);
        Root<ProcesadorComponente> comp = cq.from(ProcesadorComponente.class);
        Predicate condiciones = cb.and(cb.equal(comp.get("idProcesadorComponente"), id));
        cq.select(comp);
        cq.where(condiciones);
        return em.createQuery(cq).getResultList();
    }
    
}
