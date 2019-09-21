/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.MemoriasComponente;
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
public class MemoriasComponenteFacade extends AbstractFacade<MemoriasComponente> implements MemoriasComponenteFacadeLocal {

    @PersistenceContext(unitName = "soportePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MemoriasComponenteFacade() {
        super(MemoriasComponente.class);
    }

    @Override
    public List<MemoriasComponente> findAsignados(int id) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<MemoriasComponente> cq = cb.createQuery(MemoriasComponente.class);
        Root<MemoriasComponente> comp = cq.from(MemoriasComponente.class);
        Predicate condiciones = cb.and(cb.equal(comp.get("idMemoriasComponente"), id));
        cq.select(comp);
        cq.where(condiciones);
        return em.createQuery(cq).getResultList();
    }

}
