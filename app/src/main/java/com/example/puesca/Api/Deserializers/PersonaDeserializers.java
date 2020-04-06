package com.example.puesca.Api.Deserializers;

import com.example.puesca.Model.Persona;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class PersonaDeserializers implements JsonDeserializer {
    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonArray usuario = json.getAsJsonObject().get("persona").getAsJsonArray();
        Gson gson = new Gson();
        Persona obj = gson.fromJson(usuario,Persona.class);
        return obj;
    }
}
