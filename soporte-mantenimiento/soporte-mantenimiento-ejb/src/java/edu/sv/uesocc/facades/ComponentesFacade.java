/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Componentes;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author o-a19
 */
@Stateless
public class ComponentesFacade extends AbstractFacade<Componentes> implements ComponentesFacadeLocal {

    @PersistenceContext(unitName = "soportePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComponentesFacade() {
        super(Componentes.class);
    }

//    Verifica las condiciones de busqueda y relaciona las tablas que se pasan por el filtro
    private Predicate obtenerCondiciones(CriteriaBuilder cb, Root<Componentes> comp, Map<String, Object> filters) {
        Predicate condiciones = cb.conjunction();
        String wc = "%";

        for (Map.Entry<String, Object> filtro : filters.entrySet()) {
            Path<Componentes> path = null;
            if (filtro.getKey().contains(".") && !filtro.getValue().equals("")) {
                String[] relacion = filtro.getKey().split("\\.");
                if (relacion.length == 2) {
                    path = comp.join(relacion[0]);
                    String key = relacion[1];
                    condiciones = cb.and(condiciones, cb.equal(path.get(key), filtro.getValue()));
                } else {
                    path = comp.join(relacion[0]).join(relacion[1]);
                    String key = relacion[2];
                    condiciones = cb.and(condiciones, cb.equal(path.get(key), filtro.getValue()));
                }
            } else {
                if (!filtro.getValue().equals("")) {
                    path = comp.get(filtro.getKey());
                    String valor = wc + filtro.getValue() + wc;
                    condiciones = cb.and(condiciones, cb.like(path.as(String.class), valor));
                }
            }
        }

        return condiciones;
    }
    
//    Devuelve la cantidad de registros
    @Override
    public int countByDataFilter(Map<String, Object> filters) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Componentes> comp = cq.from(Componentes.class);
        cq.where(obtenerCondiciones(cb, comp, filters));
        cq.select(cb.count(comp));

        return em.createQuery(cq).getSingleResult().intValue();
    }
    
//    Ejecuta la operacion y devuelve la lista de registros
    @Override
    public List<Componentes> findByDataFilter(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Componentes> cq;
        cq = cb.createQuery(Componentes.class);
        Root<Componentes> comp = cq.from(Componentes.class);
        cq.where(obtenerCondiciones(cb, comp, filters));
        if (sortField != null) {
            if ("Asc".equals(sortOrder)) {
                cq.orderBy(cb.asc(comp.get(sortField)));
            } else if ("Des".equals(sortOrder)) {
                cq.orderBy(cb.desc(comp.get(sortField)));
            }
        }
        return em.createQuery(cq).setFirstResult(first).setMaxResults(pageSize).getResultList();
    }
    
    @Override
    public List<Componentes> findDisponibles(){
        boolean estado = true;
        boolean asignado = false;
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Componentes> cq =  cb.createQuery(Componentes.class);
        Root<Componentes> comp = cq.from(Componentes.class);
        Predicate condiciones = cb.and(cb.equal(comp.get("estado"), estado), cb.equal(comp.get("asignado"), asignado));
        cq.select(comp);
        cq.where(condiciones);
        
        return em.createQuery(cq).getResultList();
    }

}
