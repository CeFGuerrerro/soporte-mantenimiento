/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.VistasLoggin;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface VistasLogginFacadeLocal {

    boolean create(VistasLoggin vistasLoggin);

    boolean edit(VistasLoggin vistasLoggin);

    boolean remove(VistasLoggin vistasLoggin);

    VistasLoggin find(Object id);

    List<VistasLoggin> findAll();

    List<VistasLoggin> findRange(int[] range);

    int count();
    
}
