package com.example.puesca.Model;

import java.util.ArrayList;

public class TipoServicioSerializers {
    private ArrayList<TipoServicio> tipo;

    public TipoServicioSerializers() {
    }

    public TipoServicioSerializers(ArrayList<TipoServicio> tipo) {
        this.tipo = tipo;
    }

    public ArrayList<TipoServicio> getTipo() {
        return tipo;
    }

    public void setTipo(ArrayList<TipoServicio> tipo) {
        this.tipo = tipo;
    }
}
