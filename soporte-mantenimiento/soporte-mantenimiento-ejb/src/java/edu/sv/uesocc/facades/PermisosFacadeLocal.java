/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Loggin;
import edu.sv.uesocc.entidades.Permisos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface PermisosFacadeLocal {

    boolean create(Permisos permisos);

    boolean edit(Permisos permisos);

    boolean remove(Permisos permisos);

    Permisos find(Object id);

    List<Permisos> findAll();

    List<Permisos> findRange(int[] range);

    int count();
    
    Permisos obtenerAccesos(Loggin id);    
}
