package com.example.puesca.Model;

import java.util.ArrayList;

public class UsuariosSerializer {
    ArrayList<Usuarios> user;

    public UsuariosSerializer(ArrayList<Usuarios> user) {
        this.user = user;
    }

    public UsuariosSerializer() {
    }

    public ArrayList<Usuarios> getUser() {
        return user;
    }

    public void setUser(ArrayList<Usuarios> user) {
        this.user = user;
    }
}
