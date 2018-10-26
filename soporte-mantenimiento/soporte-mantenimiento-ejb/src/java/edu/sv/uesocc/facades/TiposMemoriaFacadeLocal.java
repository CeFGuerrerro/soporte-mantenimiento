/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.TiposMemoria;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface TiposMemoriaFacadeLocal {

    boolean create(TiposMemoria tiposMemoria);

    boolean edit(TiposMemoria tiposMemoria);

    boolean remove(TiposMemoria tiposMemoria);

    TiposMemoria find(Object id);

    List<TiposMemoria> findAll();

    List<TiposMemoria> findRange(int[] range);

    int count();
    
}
