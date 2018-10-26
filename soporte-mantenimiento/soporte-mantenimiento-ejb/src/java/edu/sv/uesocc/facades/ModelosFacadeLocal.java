/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Modelos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface ModelosFacadeLocal {

    boolean create(Modelos modelos);

    boolean edit(Modelos modelos);

    boolean remove(Modelos modelos);

    Modelos find(Object id);

    List<Modelos> findAll();

    List<Modelos> findRange(int[] range);

    int count();
    
}
