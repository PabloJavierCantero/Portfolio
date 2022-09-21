
package com.Portfolio.Cantero.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hys {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private int ingles;
    private int resolucion;
    private int gestion;
    private int equipo;
    private int habilidades;
    private int fullstack;

    public Hys() {
    }

    public Hys(int ingles, int resolucion, int gestion, int equipo, int habilidades, int fullstack) {
        this.ingles = ingles;
        this.resolucion = resolucion;
        this.gestion = gestion;
        this.equipo = equipo;
        this.habilidades = habilidades;
        this.fullstack = fullstack;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
