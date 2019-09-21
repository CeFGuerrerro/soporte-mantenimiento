/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.TarjetasVideoComponente;
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
public class TarjetasVideoComponenteFacade extends AbstractFacade<TarjetasVideoComponente> implements TarjetasVideoComponenteFacadeLocal {

    @PersistenceContext(unitName = "soportePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TarjetasVideoComponenteFacade() {
        super(TarjetasVideoComponente.class);
    }

    @Override
    public List<TarjetasVideoComponente> findAsignados(int id) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<TarjetasVideoComponente> cq = cb.createQuery(TarjetasVideoComponente.class);
        Root<TarjetasVideoComponente> comp = cq.from(TarjetasVideoComponente.class);
        Predicate condiciones = cb.and(cb.equal(comp.get("idTarjetaVideoComponente"), id));
        cq.select(comp);
        cq.where(condiciones);
        return em.createQuery(cq).getResultList();
    }
}
