/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Motherboards;
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
 * @author o-a19
 */
@Stateless
public class MotherboardsFacade extends AbstractFacade<Motherboards> implements MotherboardsFacadeLocal {

    @PersistenceContext(unitName = "soportePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MotherboardsFacade() {
        super(Motherboards.class);
    }

    public List<Motherboards> findDisponibles() {
        boolean estado = true;
        boolean asignado = false;
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Motherboards> cq = cb.createQuery(Motherboards.class);
        Root<Motherboards> comp = cq.from(Motherboards.class);
        Predicate condiciones = cb.and(cb.equal(comp.get("estado"), estado), cb.equal(comp.get("asignado"), asignado));
        cq.select(comp);
        cq.where(condiciones);
        return em.createQuery(cq).getResultList();
    }
}
