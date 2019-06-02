/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Fuentes;
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

    @Override
    public List<Fuentes> findDisponibles() {
        boolean estado = true;
        boolean asignado = false;
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Fuentes> cq = cb.createQuery(Fuentes.class);
        Root<Fuentes> comp = cq.from(Fuentes.class);
        Predicate condiciones = cb.and(cb.equal(comp.get("estado"), estado), cb.equal(comp.get("asignado"), asignado));
        cq.select(comp);
        cq.where(condiciones);
        return em.createQuery(cq).getResultList();
    }

}
