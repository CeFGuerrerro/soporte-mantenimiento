/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Procesadores;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface ProcesadoresFacadeLocal {

    boolean create(Procesadores procesadores);

    boolean edit(Procesadores procesadores);

    boolean remove(Procesadores procesadores);

    Procesadores find(Object id);

    List<Procesadores> findAll();

    List<Procesadores> findRange(int[] range);

    int count();
    
}
