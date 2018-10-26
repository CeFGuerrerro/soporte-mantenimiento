/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Soluciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface SolucionesFacadeLocal {

    boolean create(Soluciones soluciones);

    boolean edit(Soluciones soluciones);

    boolean remove(Soluciones soluciones);

    Soluciones find(Object id);

    List<Soluciones> findAll();

    List<Soluciones> findRange(int[] range);

    int count();
    
}
