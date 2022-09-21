
package com.Portfolio.Cantero.dto;

import javax.validation.constraints.NotBlank;


public class DtoExperience {
    
    @NotBlank
    private String nombre;
    private String descripcion;
    @NotBlank
    private String fecha; 
    @NotBlank
    private String puesto;

    public DtoExperience() {
    }

    public DtoExperience(String nombre, String descripcion, String fecha, String puesto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.puesto = puesto;
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

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
    
    
}
