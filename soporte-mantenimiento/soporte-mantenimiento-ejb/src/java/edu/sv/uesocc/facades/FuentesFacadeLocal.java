/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Fuentes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface FuentesFacadeLocal {

    boolean create(Fuentes fuentes);

    boolean edit(Fuentes fuentes);

    boolean remove(Fuentes fuentes);

    Fuentes find(Object id);

    List<Fuentes> findAll();

    List<Fuentes> findRange(int[] range);

    int count();
    
}
