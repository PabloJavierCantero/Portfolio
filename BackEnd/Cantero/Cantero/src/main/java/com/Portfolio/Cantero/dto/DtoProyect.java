
package com.Portfolio.Cantero.dto;

import javax.validation.constraints.NotBlank;


public class DtoProyect {
    
    @NotBlank
    private String nombre;
    @NotBlank
    private String fecha;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String link;

    public DtoProyect() {
    }

    public DtoProyect(String nombre, String fecha, String descripcion, String link) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.link = link;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
    
    
}
