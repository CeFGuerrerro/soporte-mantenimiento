/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.EquiposAsignados;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface EquiposAsignadosFacadeLocal {

    boolean create(EquiposAsignados equiposAsignados);

    boolean edit(EquiposAsignados equiposAsignados);

    boolean remove(EquiposAsignados equiposAsignados);

    EquiposAsignados find(Object id);

    List<EquiposAsignados> findAll();

    List<EquiposAsignados> findRange(int[] range);

    int count();
    
}
