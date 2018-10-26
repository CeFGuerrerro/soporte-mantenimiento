/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.DiaNoLaboral;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface DiaNoLaboralFacadeLocal {

    boolean create(DiaNoLaboral diaNoLaboral);

    boolean edit(DiaNoLaboral diaNoLaboral);

    boolean remove(DiaNoLaboral diaNoLaboral);

    DiaNoLaboral find(Object id);

    List<DiaNoLaboral> findAll();

    List<DiaNoLaboral> findRange(int[] range);

    int count();
    
}
