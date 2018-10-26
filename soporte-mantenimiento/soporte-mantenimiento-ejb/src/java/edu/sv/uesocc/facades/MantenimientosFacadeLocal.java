/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Mantenimientos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface MantenimientosFacadeLocal {

    boolean create(Mantenimientos mantenimientos);

    boolean edit(Mantenimientos mantenimientos);

    boolean remove(Mantenimientos mantenimientos);

    Mantenimientos find(Object id);

    List<Mantenimientos> findAll();

    List<Mantenimientos> findRange(int[] range);

    int count();
    
}
