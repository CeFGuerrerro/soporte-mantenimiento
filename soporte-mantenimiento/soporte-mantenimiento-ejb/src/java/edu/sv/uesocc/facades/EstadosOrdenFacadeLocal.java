/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.EstadosOrden;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface EstadosOrdenFacadeLocal {

    boolean create(EstadosOrden estadosOrden);

    boolean edit(EstadosOrden estadosOrden);

    boolean remove(EstadosOrden estadosOrden);

    EstadosOrden find(Object id);

    List<EstadosOrden> findAll();

    List<EstadosOrden> findRange(int[] range);

    int count();
    
}
