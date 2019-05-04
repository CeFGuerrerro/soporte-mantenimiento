/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Loggin;
import edu.sv.uesocc.entidades.Permisos;
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
public class PermisosFacade extends AbstractFacade<Permisos> implements PermisosFacadeLocal {

    @PersistenceContext(unitName = "soportePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PermisosFacade() {
        super(Permisos.class);
    }
    
    @Override
    public Permisos obtenerAccesos(Loggin id){
        Permisos acceso;
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Permisos> cq =  cb.createQuery(Permisos.class);
        Root<Permisos> us = cq.from(Permisos.class);
        Predicate condiciones = cb.equal(us.get("idLoggin"), id);
        cq.select(us);
        cq.where(condiciones);
        List<Permisos> list = em.createQuery(cq).getResultList();
            if (!list.isEmpty()){
                acceso = list.get(0);
            }else{
                acceso = new Permisos();
            }
        return acceso;
    }
    
}
