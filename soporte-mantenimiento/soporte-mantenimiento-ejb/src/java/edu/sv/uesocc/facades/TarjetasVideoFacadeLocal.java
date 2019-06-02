/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.facades;

import edu.sv.uesocc.entidades.TarjetasVideo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author o-a19
 */
@Local
public interface TarjetasVideoFacadeLocal {

    boolean create(TarjetasVideo tarjetasVideo);

    boolean edit(TarjetasVideo tarjetasVideo);

    boolean remove(TarjetasVideo tarjetasVideo);

    TarjetasVideo find(Object id);

    List<TarjetasVideo> findAll();

    List<TarjetasVideo> findRange(int[] range);

    int count();

    public List<TarjetasVideo> findDisponibles();

}
