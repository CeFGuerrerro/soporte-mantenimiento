/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.controladores;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author o-a19
 */
@Named(value = "marcasMB")
@SessionScoped
public class MarcasMB implements Serializable {

    /**
     * Creates a new instance of MarcasMB
     */
    public MarcasMB() {
    }
    
}
