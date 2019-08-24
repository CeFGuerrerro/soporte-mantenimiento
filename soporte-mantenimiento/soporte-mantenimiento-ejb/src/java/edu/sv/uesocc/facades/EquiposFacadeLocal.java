/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Equipos;
import edu.sv.uesocc.entidades.Responsables;
import edu.sv.uesocc.entidades.Ubicaciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface EquiposFacadeLocal {

    boolean create(Equipos equipos);

    boolean edit(Equipos equipos);

    boolean remove(Equipos equipos);

    Equipos find(Object id);

    List<Equipos> findAll();
    
    List<Equipos> findPorResponsable(Responsables resp);
    
    List<Equipos> findPorUbicacionDeResponsable(Responsables resp, Ubicaciones ubi);

    List<Equipos> findRange(int[] range);

    int count();
        
}
