/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Usuarios;
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
 * @author Cybertron
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> implements UsuariosFacadeLocal {

    @PersistenceContext(unitName = "soportePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }

    @Override
    public boolean iniciarSesion(Usuarios us) {
        boolean rs;
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Usuarios> cq =  cb.createQuery(Usuarios.class);
        Root<Usuarios> comp = cq.from(Usuarios.class);
        Predicate condiciones = cb.and(cb.equal(comp.get("idUbicacion"), us.getIdUbicacion()), cb.equal(comp.get("password"), us.getPassword()));
        cq.select(comp);
        cq.where(condiciones);
        
        List<Usuarios> listUsuario = em.createQuery(cq).getResultList();
            if (!listUsuario.isEmpty()){
                rs = true;
            }else{
                rs = false;
            }
        
        return rs;
   }
    
}
