/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Capacidades;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface CapacidadesFacadeLocal {

    boolean create(Capacidades capacidades);

    boolean edit(Capacidades capacidades);

    boolean remove(Capacidades capacidades);

    Capacidades find(Object id);

    List<Capacidades> findAll();

    List<Capacidades> findRange(int[] range);

    int count();
    
}
