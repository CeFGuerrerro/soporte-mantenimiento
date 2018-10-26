/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.EstadosSolicitud;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface EstadosSolicitudFacadeLocal {

    boolean create(EstadosSolicitud estadosSolicitud);

    boolean edit(EstadosSolicitud estadosSolicitud);

    boolean remove(EstadosSolicitud estadosSolicitud);

    EstadosSolicitud find(Object id);

    List<EstadosSolicitud> findAll();

    List<EstadosSolicitud> findRange(int[] range);

    int count();
    
}
