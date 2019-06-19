/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Equipos;
import edu.sv.uesocc.entidades.Responsables;
import edu.sv.uesocc.entidades.Ubicaciones;
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
public class EquiposFacade extends AbstractFacade<Equipos> implements EquiposFacadeLocal {

    @PersistenceContext(unitName = "soportePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EquiposFacade() {
        super(Equipos.class);
    }

    @Override
    public List<Equipos> findPorResponsable(Responsables resp) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Equipos> cq =  cb.createQuery(Equipos.class);
        Root<Equipos> comp = cq.from(Equipos.class);
        Predicate condiciones = cb.and(cb.equal(comp.get("idResponsable"), resp));
        cq.select(comp);
        cq.where(condiciones);
        
        return em.createQuery(cq).getResultList();
    }

    @Override
    public List<Equipos> findPorUbicacionDeResponsable(Responsables resp, Ubicaciones ubi) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Equipos> cq =  cb.createQuery(Equipos.class);
        Root<Equipos> comp = cq.from(Equipos.class);
        Predicate condiciones = cb.and(cb.equal(comp.get("idResponsable"), resp), cb.equal(comp.get("idUbicacion"), ubi));
        cq.select(comp);
        cq.where(condiciones);
        
        return em.createQuery(cq).getResultList();
    }
    
}
