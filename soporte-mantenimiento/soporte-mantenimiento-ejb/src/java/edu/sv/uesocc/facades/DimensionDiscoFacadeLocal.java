/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.DimensionDisco;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Gaby
 */
@Local
public interface DimensionDiscoFacadeLocal {

    boolean create(DimensionDisco dimensionDisco);

    boolean edit(DimensionDisco dimensionDisco);

    boolean remove(DimensionDisco dimensionDisco);

    DimensionDisco find(Object id);

    List<DimensionDisco> findAll();

    List<DimensionDisco> findRange(int[] range);

    int count();
    
}
