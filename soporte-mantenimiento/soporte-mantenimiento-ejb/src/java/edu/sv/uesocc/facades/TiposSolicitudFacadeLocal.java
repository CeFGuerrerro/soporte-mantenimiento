/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.TiposSolicitud;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cybertron
 */
@Local
public interface TiposSolicitudFacadeLocal {

    boolean create(TiposSolicitud tiposSolicitud);

    boolean edit(TiposSolicitud tiposSolicitud);

    boolean remove(TiposSolicitud tiposSolicitud);

    TiposSolicitud find(Object id);

    List<TiposSolicitud> findAll();

    List<TiposSolicitud> findRange(int[] range);

    int count();
    
}
