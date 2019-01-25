/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Responsables;
import edu.sv.uesocc.entidades.Ubicaciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface ResponsablesFacadeLocal {

    boolean create(Responsables responsables);

    boolean edit(Responsables responsables);

    boolean remove(Responsables responsables);

    Responsables find(Object id);

    List<Responsables> findAll();
    
    List<Responsables> findPorUbicacion(Ubicaciones ubi);

    List<Responsables> findRange(int[] range);

    int count();
    
}
