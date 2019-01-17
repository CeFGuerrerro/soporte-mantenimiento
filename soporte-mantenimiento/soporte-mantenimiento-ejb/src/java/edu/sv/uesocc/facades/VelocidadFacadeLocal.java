/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Velocidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Gaby
 */
@Local
public interface VelocidadFacadeLocal {

    boolean create(Velocidad velocidad);

    boolean edit(Velocidad velocidad);

    boolean remove(Velocidad velocidad);

    Velocidad find(Object id);

    List<Velocidad> findAll();

    List<Velocidad> findRange(int[] range);

    int count();
    
}
