/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.TiposMantenimiento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface TiposMantenimientoFacadeLocal {

    boolean create(TiposMantenimiento tiposMantenimiento);

    boolean edit(TiposMantenimiento tiposMantenimiento);

    boolean remove(TiposMantenimiento tiposMantenimiento);

    TiposMantenimiento find(Object id);

    List<TiposMantenimiento> findAll();

    List<TiposMantenimiento> findRange(int[] range);

    int count();
    
}
