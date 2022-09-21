
package com.Portfolio.Cantero.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Education {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;    
    private String nombre;
    private String descripcion;
    private String fecha;
    private String titulo;

    public Education() {
    }

    public Education(String nombre, String descripcion, String fecha, String titulo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
    
    
}
