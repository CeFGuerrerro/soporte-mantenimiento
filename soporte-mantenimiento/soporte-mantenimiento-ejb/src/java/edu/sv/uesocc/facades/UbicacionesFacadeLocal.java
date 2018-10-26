/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Ubicaciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface UbicacionesFacadeLocal {

    boolean create(Ubicaciones ubicaciones);

    boolean edit(Ubicaciones ubicaciones);

    boolean remove(Ubicaciones ubicaciones);

    Ubicaciones find(Object id);

    List<Ubicaciones> findAll();

    List<Ubicaciones> findRange(int[] range);

    int count();
    
}
