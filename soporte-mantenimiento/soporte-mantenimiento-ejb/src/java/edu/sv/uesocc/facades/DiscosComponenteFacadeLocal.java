/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.DiscosComponente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Gaby
 */
@Local
public interface DiscosComponenteFacadeLocal {

    boolean create(DiscosComponente discosComponente);

    boolean edit(DiscosComponente discosComponente);

    boolean remove(DiscosComponente discosComponente);

    DiscosComponente find(Object id);

    List<DiscosComponente> findAll();

    List<DiscosComponente> findRange(int[] range);

    int count();
    
}
