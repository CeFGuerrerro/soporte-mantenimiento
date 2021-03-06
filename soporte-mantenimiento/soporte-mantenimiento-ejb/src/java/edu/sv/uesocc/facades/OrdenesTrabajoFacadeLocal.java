/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.OrdenesTrabajo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface OrdenesTrabajoFacadeLocal {

    boolean create(OrdenesTrabajo ordenesTrabajo);

    boolean edit(OrdenesTrabajo ordenesTrabajo);

    boolean remove(OrdenesTrabajo ordenesTrabajo);

    OrdenesTrabajo find(Object id);

    List<OrdenesTrabajo> findAll();

    List<OrdenesTrabajo> findRange(int[] range);

    int count();
    
}
