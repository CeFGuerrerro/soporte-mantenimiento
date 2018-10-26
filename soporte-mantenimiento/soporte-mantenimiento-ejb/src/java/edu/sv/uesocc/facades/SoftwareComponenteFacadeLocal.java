/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.SoftwareComponente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface SoftwareComponenteFacadeLocal {

    boolean create(SoftwareComponente softwareComponente);

    boolean edit(SoftwareComponente softwareComponente);

    boolean remove(SoftwareComponente softwareComponente);

    SoftwareComponente find(Object id);

    List<SoftwareComponente> findAll();

    List<SoftwareComponente> findRange(int[] range);

    int count();
    
}
