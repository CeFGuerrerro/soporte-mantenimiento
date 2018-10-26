/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.DetallesOrdenTrabajo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface DetallesOrdenTrabajoFacadeLocal {

    boolean create(DetallesOrdenTrabajo detallesOrdenTrabajo);

    boolean edit(DetallesOrdenTrabajo detallesOrdenTrabajo);

    boolean remove(DetallesOrdenTrabajo detallesOrdenTrabajo);

    DetallesOrdenTrabajo find(Object id);

    List<DetallesOrdenTrabajo> findAll();

    List<DetallesOrdenTrabajo> findRange(int[] range);

    int count();
    
}
