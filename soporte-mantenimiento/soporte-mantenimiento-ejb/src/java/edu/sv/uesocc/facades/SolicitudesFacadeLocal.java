/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Solicitudes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface SolicitudesFacadeLocal {

    boolean create(Solicitudes solicitudes);

    boolean edit(Solicitudes solicitudes);

    boolean remove(Solicitudes solicitudes);

    Solicitudes find(Object id);

    List<Solicitudes> findAll();
    
    Solicitudes findLastRecord();

    List<Solicitudes> findRange(int[] range);

    int count();
    
}
