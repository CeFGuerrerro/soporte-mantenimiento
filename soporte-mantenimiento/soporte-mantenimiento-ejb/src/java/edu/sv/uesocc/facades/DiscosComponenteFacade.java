/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.DiscosComponente;
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
public class DiscosComponenteFacade extends AbstractFacade<DiscosComponente> implements DiscosComponenteFacadeLocal {

    @PersistenceContext(unitName = "soportePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DiscosComponenteFacade() {
        super(DiscosComponente.class);
    }

    @Override
    public List<DiscosComponente> findAsignados(int id) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<DiscosComponente> cq = cb.createQuery(DiscosComponente.class);
        Root<DiscosComponente> comp = cq.from(DiscosComponente.class);
        Predicate condiciones = cb.and(cb.equal(comp.get("idDiscosComponente"), id));
        cq.select(comp);
        cq.where(condiciones);
        return em.createQuery(cq).getResultList();
    }

    
}
