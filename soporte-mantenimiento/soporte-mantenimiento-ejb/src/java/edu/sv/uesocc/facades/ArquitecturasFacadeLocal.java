/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Arquitecturas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface ArquitecturasFacadeLocal {

    boolean create(Arquitecturas arquitecturas);

    boolean edit(Arquitecturas arquitecturas);

    boolean remove(Arquitecturas arquitecturas);

    Arquitecturas find(Object id);

    List<Arquitecturas> findAll();

    List<Arquitecturas> findRange(int[] range);

    int count();
    
}
