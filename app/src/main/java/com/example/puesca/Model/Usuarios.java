package com.example.puesca.Model;

import java.io.Serializable;

public class Usuarios  implements Serializable {
    public int idusuarios;
    public String nombre;
    public String cedula;
    public String estado;
    public String clave;

    public Usuarios(String nombre, String cedula, String estado,String clave) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.estado = estado;
        this.clave = clave;
    }

    public Usuarios() {

    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getIdusuarios() {
        return idusuarios;
    }

    public void setIdusuarios(int idusuarios) {
        this.idusuarios = idusuarios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
