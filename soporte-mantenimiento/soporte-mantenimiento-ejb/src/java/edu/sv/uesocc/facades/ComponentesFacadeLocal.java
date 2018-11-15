/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Componentes;
import java.util.List;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface ComponentesFacadeLocal {

    boolean create(Componentes componentes);

    boolean edit(Componentes componentes);

    boolean remove(Componentes componentes);

    Componentes find(Object id);

    List<Componentes> findAll();

    List<Componentes> findRange(int[] range);

    int count();
    
    int countByDataFilter(Map<String, Object> filters);
    
    List<Componentes> findByDataFilter(int first, int pageSize, String sortField, String sortOrder, Map<String, Object> filters);

    public List<Componentes> findDisponibles();
    
}
