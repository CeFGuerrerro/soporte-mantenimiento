/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Usuarios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cybertron
 */
@Local
public interface UsuariosFacadeLocal {

    boolean create(Usuarios usuarios);

    boolean edit(Usuarios usuarios);

    boolean remove(Usuarios usuarios);

    Usuarios find(Object id);

    List<Usuarios> findAll();

    List<Usuarios> findRange(int[] range);

    int count();
    
    boolean iniciarSesion (Usuarios us);
    
}
