
package edu.sv.uesocc.controladores;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author o-a19
 */
@Named(value = "componentesMB")
@SessionScoped
public class ComponentesMB implements Serializable {

    /**
     * Creates a new instance of ComponentesMB
     */
    public ComponentesMB() {
    }
    
}
