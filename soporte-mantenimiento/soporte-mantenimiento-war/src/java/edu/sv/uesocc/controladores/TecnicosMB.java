
package edu.sv.uesocc.controladores;

import edu.sv.uesocc.entidades.Tecnicos;
import edu.sv.uesocc.facades.TecnicosFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;


@Named(value = "tecnicosMB")
@SessionScoped
public class TecnicosMB implements Serializable {

    
    public TecnicosMB() {
    }
    
     @EJB
     private TecnicosFacadeLocal tecnicoEJB;
     private List<Tecnicos> tecnicos = new ArrayList<>();
     private Tecnicos tecnico = new Tecnicos();

    public List<Tecnicos> getTecnicos() {
        return tecnicos;
    }

    public void setTecnicos(List<Tecnicos> tecnicos) {
        this.tecnicos = tecnicos;
    }

    public Tecnicos getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnicos tecnico) {
        this.tecnico = tecnico;
    }
     
     
    
}
