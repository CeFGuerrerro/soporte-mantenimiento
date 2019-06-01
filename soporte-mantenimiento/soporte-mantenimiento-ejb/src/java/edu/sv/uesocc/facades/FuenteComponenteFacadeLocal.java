/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.FuenteComponente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Gaby
 */
@Local
public interface FuenteComponenteFacadeLocal {

    boolean create(FuenteComponente fuenteComponente);

    boolean edit(FuenteComponente fuenteComponente);

    boolean remove(FuenteComponente fuenteComponente);

    FuenteComponente find(Object id);

    List<FuenteComponente> findAll();

    List<FuenteComponente> findRange(int[] range);

    int count();
    
}
