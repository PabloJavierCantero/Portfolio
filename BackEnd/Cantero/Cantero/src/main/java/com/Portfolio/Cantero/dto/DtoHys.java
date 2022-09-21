
package com.Portfolio.Cantero.dto;

import javax.validation.constraints.NotBlank;


public class DtoHys {
    
    @NotBlank
    private int ingles;
    @NotBlank
    private int resolucion;
    @NotBlank
    private int gestion;
    @NotBlank
    private int equipo;
    @NotBlank
    private int habilidades;
    @NotBlank
    private int fullstack;
    @NotBlank

    public DtoHys() {
    }

    public DtoHys(int ingles, int resolucion, int gestion, int equipo, int habilidades, int fullstack) {
        this.ingles = ingles;
        this.resolucion = resolucion;
        this.gestion = gestion;
        this.equipo = equipo;
        this.habilidades = habilidades;
        this.fullstack = fullstack;
    }

    public int getIngles() {
        return ingles;
    }

    public void setIngles(int ingles) {
        this.ingles = ingles;
    }

    public int getResolucion() {
        return resolucion;
    }

    public void setResolucion(int resolucion) {
        this.resolucion = resolucion;
    }

    public int getGestion() {
        return gestion;
    }

    public void setGestion(int gestion) {
        this.gestion = gestion;
    }

    public int getEquipo() {
        return equipo;
    }

    public void setEquipo(int equipo) {
        this.equipo = equipo;
    }

    public int getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(int habilidades) {
        this.habilidades = habilidades;
    }

    public int getFullstack() {
        return fullstack;
    }

    public void setFullstack(int fullstack) {
        this.fullstack = fullstack;
    }
    
    

    
    
    
}
