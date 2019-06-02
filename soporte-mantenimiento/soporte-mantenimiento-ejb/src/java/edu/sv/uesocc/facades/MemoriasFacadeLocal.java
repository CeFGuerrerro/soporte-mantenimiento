/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Memorias;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface MemoriasFacadeLocal {

    boolean create(Memorias memorias);

    boolean edit(Memorias memorias);

    boolean remove(Memorias memorias);

    Memorias find(Object id);

    List<Memorias> findAll();

    List<Memorias> findRange(int[] range);

    int count();

    public List<Memorias> findDisponibles();

}
