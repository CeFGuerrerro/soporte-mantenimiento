/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.ProcesadorComponente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Gaby
 */
@Local
public interface ProcesadorComponenteFacadeLocal {

    boolean create(ProcesadorComponente procesadorComponente);

    boolean edit(ProcesadorComponente procesadorComponente);

    boolean remove(ProcesadorComponente procesadorComponente);

    ProcesadorComponente find(Object id);

    List<ProcesadorComponente> findAll();

    List<ProcesadorComponente> findRange(int[] range);
    
    List<ProcesadorComponente> findAsignados(int id);

    int count();

}
