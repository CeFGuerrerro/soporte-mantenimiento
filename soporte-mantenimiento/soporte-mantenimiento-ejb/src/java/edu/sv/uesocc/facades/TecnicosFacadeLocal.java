/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Tecnicos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface TecnicosFacadeLocal {

    boolean create(Tecnicos tecnicos);

    boolean edit(Tecnicos tecnicos);

    boolean remove(Tecnicos tecnicos);

    Tecnicos find(Object id);

    List<Tecnicos> findAll();

    List<Tecnicos> findRange(int[] range);

    public List<Tecnicos> findAllWithFilter(int filter);

    int count();

}
