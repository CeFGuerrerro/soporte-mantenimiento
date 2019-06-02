/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.Discos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface DiscosFacadeLocal {

    boolean create(Discos discos);

    boolean edit(Discos discos);

    boolean remove(Discos discos);

    Discos find(Object id);

    List<Discos> findAll();

    List<Discos> findRange(int[] range);

    int count();

    public List<Discos> findDisponibles();
}
