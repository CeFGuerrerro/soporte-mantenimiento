/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Resposables;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface ResposablesFacadeLocal {

    boolean create(Resposables resposables);

    boolean edit(Resposables resposables);

    boolean remove(Resposables resposables);

    Resposables find(Object id);

    List<Resposables> findAll();

    List<Resposables> findRange(int[] range);

    int count();
    
}
