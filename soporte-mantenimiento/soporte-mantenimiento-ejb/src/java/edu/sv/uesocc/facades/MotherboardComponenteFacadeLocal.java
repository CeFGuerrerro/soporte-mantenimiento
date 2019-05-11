/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.MotherboardComponente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Gaby
 */
@Local
public interface MotherboardComponenteFacadeLocal {

    boolean create(MotherboardComponente motherboardComponente);

    boolean edit(MotherboardComponente motherboardComponente);

    boolean remove(MotherboardComponente motherboardComponente);

    MotherboardComponente find(Object id);

    List<MotherboardComponente> findAll();

    List<MotherboardComponente> findRange(int[] range);

    int count();
    
}
