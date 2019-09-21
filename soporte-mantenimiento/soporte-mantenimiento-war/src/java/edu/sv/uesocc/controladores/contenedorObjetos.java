/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sv.uesocc.controladores;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gaby
 */
public class contenedorObjetos {
    private int id;
    private String numeroSerie;
    private String marca;
    private String modelo;
    private String puertos;
    private String potencia;
    private String socket;
    private String salidaVideo;
    private String arquitectura;
    private String capacidad;
    private String tipoObjeto;
    private String velocidad;

    public contenedorObjetos() {
        id=0;
        numeroSerie = "";
        marca = "";
        modelo = "";
        puertos = "";
        potencia = "";
        socket = "";
        salidaVideo = "";
        arquitectura = "";
        capacidad = "";
        tipoObjeto = "";
        velocidad = "";
    }

    public contenedorObjetos(int id,String numeroSerie, String marca, String modelo, String puertos, String potencia, String socket, String salidaVideo, String arquitectura, String capacidad, String tipoObjeto, String velocidad) {
        this.id=id;
        this.numeroSerie = numeroSerie;
        this.marca = marca;
        this.modelo = modelo;
        this.puertos = puertos;
        this.potencia = potencia;
        this.socket = socket;
        this.salidaVideo = salidaVideo;
        this.arquitectura = arquitectura;
        this.capacidad = capacidad;
        this.tipoObjeto = tipoObjeto;
        this.velocidad = velocidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPuertos() {
        return puertos;
    }

    public void setPuertos(String puertos) {
        this.puertos = puertos;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public String getSalidaVideo() {
        return salidaVideo;
    }

    public void setSalidaVideo(String salidaVideo) {
        this.salidaVideo = salidaVideo;
    }

    public String getArquitectura() {
        return arquitectura;
    }

    public void setArquitectura(String arquitectura) {
        this.arquitectura = arquitectura;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipoObjeto() {
        return tipoObjeto;
    }

    public void setTipoObjeto(String tipoObjeto) {
        this.tipoObjeto = tipoObjeto;
    }

    public String getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }

}
