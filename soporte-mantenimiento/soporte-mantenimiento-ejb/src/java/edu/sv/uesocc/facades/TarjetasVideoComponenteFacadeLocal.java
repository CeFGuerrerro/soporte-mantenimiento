/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.TarjetasVideoComponente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Gaby
 */
@Local
public interface TarjetasVideoComponenteFacadeLocal {

    boolean create(TarjetasVideoComponente tarjetasVideoComponente);

    boolean edit(TarjetasVideoComponente tarjetasVideoComponente);

    boolean remove(TarjetasVideoComponente tarjetasVideoComponente);

    TarjetasVideoComponente find(Object id);

    List<TarjetasVideoComponente> findAll();

    List<TarjetasVideoComponente> findRange(int[] range);

    int count();
    
}
