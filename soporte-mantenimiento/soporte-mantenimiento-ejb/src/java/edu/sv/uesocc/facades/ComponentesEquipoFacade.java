/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.ComponentesEquipo;
import edu.sv.uesocc.entidades.Equipos;
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
public class ComponentesEquipoFacade extends AbstractFacade<ComponentesEquipo> implements ComponentesEquipoFacadeLocal {

    @PersistenceContext(unitName = "soportePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComponentesEquipoFacade() {
        super(ComponentesEquipo.class);
    }

    @Override
    public List<ComponentesEquipo> findHistorial(Equipos equipo) {
        boolean estado = true;
        boolean asignado = false;
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<ComponentesEquipo> cq =  cb.createQuery(ComponentesEquipo.class);
        Root<ComponentesEquipo> comp = cq.from(ComponentesEquipo.class);
        Predicate condiciones = cb.and(cb.equal(comp.get("idEquipo"), equipo));
        cq.select(comp);
        cq.where(condiciones);
        
        return em.createQuery(cq).getResultList();
    }
    
}
