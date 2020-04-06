package com.example.puesca.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.puesca.Database.DbCliente;
import com.example.puesca.Model.Persona;

import java.util.ArrayList;

public class PersonaDao {
    private DbCliente admin;
    private SQLiteDatabase db;

    public PersonaDao(Context context) {
        this.admin = new DbCliente(context,"cliente",null,1);
        this.db = this.admin.getWritableDatabase();
    }
    public void guardar_persona(Persona persona){
        ContentValues valores = new ContentValues();
        valores.put("nombre",persona.getCedula());
        valores.put("apellido",persona.getCedula());
        valores.put("cedula",persona.getCedula());
        valores.put("provincia",persona.getCedula());
        valores.put("contacto",persona.getCedula());
        valores.put("estado","ACTIVO");
        valores.put("idtipo",persona.getIdtipo());
        valores.put("idusuario",persona.getIdpersona());
        this.db.insert("persona",null,valores);
        this.db.close();
    }
    public void update_persona(Persona persona)
    {
        ContentValues valores = new ContentValues();
        valores.put("nombre",persona.getCedula());
        valores.put("apellido",persona.getCedula());
        valores.put("cedula",persona.getCedula());
        valores.put("provincia",persona.getCedula());
        valores.put("contacto",persona.getCedula());
        valores.put("estado","ACTIVO");
        valores.put("idtipo",persona.getIdtipo());
        valores.put("idusuario",persona.getIdpersona());
        this.db.update("persona",valores,"idpersona="+persona.getIdpersona(),null);
        this.db.close();
    }
    public void eliminar_persona(int id)
    {
        ContentValues valores = new ContentValues();
        valores.put("estado","INACTIVO");
        this.db.update("persona",valores,"idpersona="+id,null);
        this.db.close();
    }
    public ArrayList<Persona> listar_persona(){
        Cursor cursor = this.db.rawQuery("SELECT * FROM persona where estado='ACTIVO'",null);
        ArrayList<Persona> lista = new ArrayList<>();
        if(cursor.moveToFirst())
        {
            do{
                Persona persona = new Persona();
                persona.setIdpersona(cursor.getInt(0));
                persona.setNombre(cursor.getString(1));
                persona.setApellido(cursor.getString(2));
                persona.setCedula(cursor.getString(3));
                persona.setProvincia(cursor.getString(4));
                persona.setContacto(cursor.getString(5));
                persona.setEstado(cursor.getString(6));
                persona.setId_base(cursor.getInt(7));
                persona.setIdtipo(cursor.getInt(8));
                persona.setIdusuario(cursor.getInt(9));
                lista.add(persona);
            }while(cursor.moveToNext());
        }
        return lista;
    }
}
