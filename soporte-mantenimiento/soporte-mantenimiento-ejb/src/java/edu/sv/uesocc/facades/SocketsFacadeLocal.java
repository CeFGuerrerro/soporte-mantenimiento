/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Sockets;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface SocketsFacadeLocal {

    boolean create(Sockets sockets);

    boolean edit(Sockets sockets);

    boolean remove(Sockets sockets);

    Sockets find(Object id);

    List<Sockets> findAll();

    List<Sockets> findRange(int[] range);

    int count();
    
}
