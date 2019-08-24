/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.ComponentesEquipo;
import edu.sv.uesocc.entidades.Equipos;
import edu.sv.uesocc.entidades.Ubicaciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface ComponentesEquipoFacadeLocal {

    boolean create(ComponentesEquipo componentesEquipo);

    boolean edit(ComponentesEquipo componentesEquipo);

    boolean remove(ComponentesEquipo componentesEquipo);

    ComponentesEquipo find(Object id);

    List<ComponentesEquipo> findAll();
    
    List<ComponentesEquipo> findHistorial(Equipos equipo);
    
    List<ComponentesEquipo> findEquiposActivosUbicacion(Ubicaciones ubicacion);

    List<ComponentesEquipo> findRange(int[] range);

    int count();
    
}
