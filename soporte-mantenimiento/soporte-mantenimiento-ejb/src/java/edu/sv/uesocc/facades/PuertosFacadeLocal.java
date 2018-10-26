/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Puertos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface PuertosFacadeLocal {

    boolean create(Puertos puertos);

    boolean edit(Puertos puertos);

    boolean remove(Puertos puertos);

    Puertos find(Object id);

    List<Puertos> findAll();

    List<Puertos> findRange(int[] range);

    int count();
    
}
