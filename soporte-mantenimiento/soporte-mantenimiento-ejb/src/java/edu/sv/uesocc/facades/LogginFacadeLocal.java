/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Loggin;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface LogginFacadeLocal {

    boolean create(Loggin loggin);

    boolean edit(Loggin loggin);

    boolean remove(Loggin loggin);

    Loggin find(Object id);

    List<Loggin> findAll();

    List<Loggin> findRange(int[] range);

    int count();
    
    Loggin iniciarSesion(Loggin loggin);
    
}
