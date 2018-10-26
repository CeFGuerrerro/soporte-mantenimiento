
package edu.sv.uesocc.controladores;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author o-a19
 */
@Named(value = "cronogramaMB")
@SessionScoped
public class CronogramaMB implements Serializable {

    
    /**
     * Creates a new instance of CronogramaMB
     */
    public CronogramaMB() {
    }
    
}
