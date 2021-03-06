/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.MemoriasComponente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Gaby
 */
@Local
public interface MemoriasComponenteFacadeLocal {

    boolean create(MemoriasComponente memoriasComponente);

    boolean edit(MemoriasComponente memoriasComponente);

    boolean remove(MemoriasComponente memoriasComponente);

    MemoriasComponente find(Object id);

    List<MemoriasComponente> findAll();

    public List<MemoriasComponente> findAsignados(int id);

    List<MemoriasComponente> findRange(int[] range);

    int count();

}
