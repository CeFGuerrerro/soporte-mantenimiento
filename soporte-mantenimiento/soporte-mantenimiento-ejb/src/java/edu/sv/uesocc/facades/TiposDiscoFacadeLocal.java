/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.TiposDisco;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface TiposDiscoFacadeLocal {

    boolean create(TiposDisco tiposDisco);

    boolean edit(TiposDisco tiposDisco);

    boolean remove(TiposDisco tiposDisco);

    TiposDisco find(Object id);

    List<TiposDisco> findAll();

    List<TiposDisco> findRange(int[] range);

    int count();
    
}
