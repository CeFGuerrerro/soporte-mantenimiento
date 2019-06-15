/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Tecnicos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author o-a19
 */
@Stateless
public class TecnicosFacade extends AbstractFacade<Tecnicos> implements TecnicosFacadeLocal {

    @PersistenceContext(unitName = "soportePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TecnicosFacade() {
        super(Tecnicos.class);
    }

    @Override
    public List<Tecnicos> findAllWithFilter(int filter) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
//        cq.select(cq.from(Tecnicos.class));
        Root<Tecnicos> tec = cq.from(Tecnicos.class);
        
        switch (filter) {
            case 1:
                cq.where(cb.and(cb.equal(tec.get("estado"), true)));
                return getEntityManager().createQuery(cq).getResultList();
            case 2:
                cq.where(cb.and(cb.equal(tec.get("estado"), false)));
                return getEntityManager().createQuery(cq).getResultList();
            default:
                return getEntityManager().createQuery(cq).getResultList();
        }
    }

}
