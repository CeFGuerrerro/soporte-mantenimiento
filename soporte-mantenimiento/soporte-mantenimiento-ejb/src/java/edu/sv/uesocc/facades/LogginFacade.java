/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Loggin;
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
public class LogginFacade extends AbstractFacade<Loggin> implements LogginFacadeLocal {

    @PersistenceContext(unitName = "soportePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LogginFacade() {
        super(Loggin.class);
    }
    
    @Override
    public Loggin iniciarSesion(Loggin log) {
        Loggin admin;
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Loggin> cq =  cb.createQuery(Loggin.class);
        Root<Loggin> comp = cq.from(Loggin.class);
        Predicate condiciones = cb.and(cb.equal(comp.get("nombreLoggin"), log.getNombreLoggin()), cb.equal(comp.get("passwoird"), log.getPasswoird()));
        cq.select(comp);
        cq.where(condiciones);
        
        List<Loggin> listLoggin = em.createQuery(cq).getResultList();
            if (!listLoggin.isEmpty()){
                admin = listLoggin.get(0);
            }else{
                admin = new Loggin();
            }
        
        return admin;
   }
    
}
