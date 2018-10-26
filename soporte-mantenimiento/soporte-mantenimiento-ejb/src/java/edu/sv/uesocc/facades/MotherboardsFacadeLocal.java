/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Motherboards;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface MotherboardsFacadeLocal {

    boolean create(Motherboards motherboards);

    boolean edit(Motherboards motherboards);

    boolean remove(Motherboards motherboards);

    Motherboards find(Object id);

    List<Motherboards> findAll();

    List<Motherboards> findRange(int[] range);

    int count();
    
}
