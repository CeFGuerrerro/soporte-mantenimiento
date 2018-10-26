/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.TiposSoftware;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface TiposSoftwareFacadeLocal {

    boolean create(TiposSoftware tiposSoftware);

    boolean edit(TiposSoftware tiposSoftware);

    boolean remove(TiposSoftware tiposSoftware);

    TiposSoftware find(Object id);

    List<TiposSoftware> findAll();

    List<TiposSoftware> findRange(int[] range);

    int count();
    
}
