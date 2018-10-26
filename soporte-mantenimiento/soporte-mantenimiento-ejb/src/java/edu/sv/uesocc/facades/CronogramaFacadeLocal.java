/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Cronograma;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface CronogramaFacadeLocal {

    boolean create(Cronograma cronograma);

    boolean edit(Cronograma cronograma);

    boolean remove(Cronograma cronograma);

    Cronograma find(Object id);

    List<Cronograma> findAll();

    List<Cronograma> findRange(int[] range);

    int count();
    
}
