package com.example.puesca.Model;

import java.util.ArrayList;

public class PersonaSerializers  {
    ArrayList<Persona> persona;

    public PersonaSerializers(ArrayList<Persona> persona) {
        this.persona = persona;
    }

    public PersonaSerializers() {
    }

    public ArrayList<Persona> getPersona() {
        return persona;
    }

    public void setPersona(ArrayList<Persona> persona) {
        this.persona = persona;
    }
}
