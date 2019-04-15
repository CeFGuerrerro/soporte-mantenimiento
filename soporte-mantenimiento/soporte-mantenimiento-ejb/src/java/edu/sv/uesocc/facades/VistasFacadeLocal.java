/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Vistas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface VistasFacadeLocal {

    boolean create(Vistas vistas);

    boolean edit(Vistas vistas);

    boolean remove(Vistas vistas);

    Vistas find(Object id);

    List<Vistas> findAll();

    List<Vistas> findRange(int[] range);

    int count();
    
}
