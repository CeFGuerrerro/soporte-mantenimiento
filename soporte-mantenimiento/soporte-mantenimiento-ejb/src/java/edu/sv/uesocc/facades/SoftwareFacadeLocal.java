/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Software;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface SoftwareFacadeLocal {

    boolean create(Software software);

    boolean edit(Software software);

    boolean remove(Software software);

    Software find(Object id);

    List<Software> findAll();

    List<Software> findRange(int[] range);

    int count();
    
}
