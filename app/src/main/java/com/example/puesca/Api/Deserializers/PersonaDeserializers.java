package com.example.puesca.Api.Deserializers;

import com.example.puesca.Model.Persona;
import com.example.puesca.Model.PersonaSerializers;
import com.example.puesca.Model.UsuariosSerializer;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class PersonaDeserializers implements JsonDeserializer {
    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonArray usuario = json.getAsJsonObject().get("persona").getAsJsonArray();
        ArrayList<Persona> persona = new ArrayList<>();
        PersonaSerializers user = new PersonaSerializers();
        for (int i = 0;i<usuario.size();i++){
            int id = usuario.get(i).getAsJsonObject().get("idpersona").getAsInt();
            String nombre = usuario.get(i).getAsJsonObject().get("nombre").getAsString();
            String apellido = usuario.get(i).getAsJsonObject().get("apellido").getAsString();
            String cedula = usuario.get(i).getAsJsonObject().get("cedula").getAsString();
            String provincia = usuario.get(i).getAsJsonObject().get("provincia").getAsString();
            int idTipo = usuario.get(i).getAsJsonObject().get("idtipo").getAsInt();
            String contacto = usuario.get(i).getAsJsonObject().get("contacto").getAsString();
            String fecha = usuario.get(i).getAsJsonObject().get("fecha_activacion").getAsString();
            String estado = usuario.get(i).getAsJsonObject().get("estado").getAsString();
            Persona obj = new Persona(id,nombre,apellido,cedula,idTipo,provincia,contacto,fecha,estado);
            persona.add(obj);
        }
        user.setPersona(persona);
        return user;
    }
}
