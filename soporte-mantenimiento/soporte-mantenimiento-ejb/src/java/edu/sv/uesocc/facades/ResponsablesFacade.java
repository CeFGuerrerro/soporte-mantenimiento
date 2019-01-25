/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

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
public class ResponsablesFacade extends AbstractFacade<Responsables> implements ResponsablesFacadeLocal {

    @PersistenceContext(unitName = "soportePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ResponsablesFacade() {
        super(Responsables.class);
    }

    @Override
    public List<Responsables> findPorUbicacion(Ubicaciones ubi) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Responsables> cq =  cb.createQuery(Responsables.class);
        Root<Responsables> comp = cq.from(Responsables.class);
        Predicate condiciones = cb.and(cb.equal(comp.get("idUbicacion"), ubi));
        cq.select(comp);
        cq.where(condiciones);
        
        return em.createQuery(cq).getResultList();
    }
    
}
