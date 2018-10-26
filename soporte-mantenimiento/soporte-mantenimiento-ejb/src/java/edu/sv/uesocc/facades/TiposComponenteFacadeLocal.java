/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.TiposComponente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface TiposComponenteFacadeLocal {

    boolean create(TiposComponente tiposComponente);

    boolean edit(TiposComponente tiposComponente);

    boolean remove(TiposComponente tiposComponente);

    TiposComponente find(Object id);

    List<TiposComponente> findAll();

    List<TiposComponente> findRange(int[] range);

    int count();
    
}
