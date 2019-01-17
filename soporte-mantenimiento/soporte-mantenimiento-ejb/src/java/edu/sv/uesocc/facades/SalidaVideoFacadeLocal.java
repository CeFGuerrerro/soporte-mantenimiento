/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.SalidaVideo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Gaby
 */
@Local
public interface SalidaVideoFacadeLocal {

    boolean create(SalidaVideo salidaVideo);

    boolean edit(SalidaVideo salidaVideo);

    boolean remove(SalidaVideo salidaVideo);

    SalidaVideo find(Object id);

    List<SalidaVideo> findAll();

    List<SalidaVideo> findRange(int[] range);

    int count();
    
}
