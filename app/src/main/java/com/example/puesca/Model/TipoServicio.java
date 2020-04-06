package com.example.puesca.Model;

public class TipoServicio {
    public int idtipo_servicio;
    public String servicio;
    public String estado;

    public TipoServicio(String servicio, String estado) {
        this.servicio = servicio;
        this.estado = estado;
    }

    public TipoServicio() {

    }

    public int getIdtipo_servicio() {
        return idtipo_servicio;
    }

    public void setIdtipo_servicio(int idtipo_servicio) {
        this.idtipo_servicio = idtipo_servicio;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
