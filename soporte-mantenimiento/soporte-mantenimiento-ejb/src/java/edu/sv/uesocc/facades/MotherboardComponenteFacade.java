/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.MotherboardComponente;
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
public class MotherboardComponenteFacade extends AbstractFacade<MotherboardComponente> implements MotherboardComponenteFacadeLocal {

    @PersistenceContext(unitName = "soportePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MotherboardComponenteFacade() {
        super(MotherboardComponente.class);
    }

    @Override
    public List<MotherboardComponente> findAsignados(int id) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<MotherboardComponente> cq = cb.createQuery(MotherboardComponente.class);
        Root<MotherboardComponente> comp = cq.from(MotherboardComponente.class);
        Predicate condiciones = cb.and(cb.equal(comp.get("idMotherboardComponente"), id));
        cq.select(comp);
        cq.where(condiciones);
        return em.createQuery(cq).getResultList();
    }

}
