
package com.Portfolio.Cantero.dto;

import javax.validation.constraints.NotBlank;


public class DtoPerson {
    
    @NotBlank
    private String fullname;
    @NotBlank
    private String imgPerfil;
    @NotBlank
    private String posicion;
    @NotBlank
    private String ubicacion;
    @NotBlank
    private String contacto;
    @NotBlank
    private String interes;
    @NotBlank
    private String acercade;

    public DtoPerson() {
    }

    public DtoPerson(String fullname, String imgPerfil, String posicion, String ubicacion, String contacto, String interes, String acercade) {
        this.fullname = fullname;
        this.imgPerfil = imgPerfil;
        this.posicion = posicion;
        this.ubicacion = ubicacion;
        this.contacto = contacto;
        this.interes = interes;
        this.acercade = acercade;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getImgPerfil() {
        return imgPerfil;
    }

    public void setImgPerfil(String imgPerfil) {
        this.imgPerfil = imgPerfil;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getInteres() {
        return interes;
    }

    public void setInteres(String interes) {
        this.interes = interes;
    }

    public String getAcercade() {
        return acercade;
    }

    public void setAcercade(String acercade) {
        this.acercade = acercade;
    }
    
    
    
}
