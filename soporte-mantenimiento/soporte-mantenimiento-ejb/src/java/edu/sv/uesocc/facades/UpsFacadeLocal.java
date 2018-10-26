/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Ups;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface UpsFacadeLocal {

    boolean create(Ups ups);

    boolean edit(Ups ups);

    boolean remove(Ups ups);

    Ups find(Object id);

    List<Ups> findAll();

    List<Ups> findRange(int[] range);

    int count();
    
}
