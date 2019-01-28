package edu.sv.uesocc.entidades;

import java.util.List;

public class Tipo {
    //Clase objeto usada para mostrar los tipos de solicitud al usuario
    private Integer id;
    private String tipo;
    
    public Tipo(){
    }
    
    public Tipo(Integer id, String tipo){
        this.id = id;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
