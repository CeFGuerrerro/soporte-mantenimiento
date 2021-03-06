/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Memorias;
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
public class MemoriasFacade extends AbstractFacade<Memorias> implements MemoriasFacadeLocal {

    @PersistenceContext(unitName = "soportePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MemoriasFacade() {
        super(Memorias.class);
    }

    @Override
    public List<Memorias> findDisponibles() {
        boolean estado = true;
        boolean asignado = false;
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Memorias> cq = cb.createQuery(Memorias.class);
        Root<Memorias> comp = cq.from(Memorias.class);
        Predicate condiciones = cb.and(cb.equal(comp.get("estado"), estado), cb.equal(comp.get("asignado"), asignado));
        cq.select(comp);
        cq.where(condiciones);
        return em.createQuery(cq).getResultList();
    }

}
