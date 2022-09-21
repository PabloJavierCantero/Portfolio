
package com.Portfolio.Cantero.dto;

import javax.validation.constraints.NotBlank;


public class DtoEducation {
    
    @NotBlank
    private String nombre;
    private String descripcion;
    @NotBlank
    private String fecha;    
    private String titulo;

    public DtoEducation() {
    }

    public DtoEducation(String nombre, String descripcion, String fecha, String titulo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.titulo = titulo;
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
