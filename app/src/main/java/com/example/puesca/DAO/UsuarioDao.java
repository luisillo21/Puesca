package com.example.puesca.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.puesca.Database.DbCliente;
import com.example.puesca.Model.Usuarios;

import java.util.ArrayList;

public class UsuarioDao {
    private DbCliente admin;
    private SQLiteDatabase db;

    public UsuarioDao(Context context) {
        this.admin = new DbCliente(context,"cliente",null,1);
        this.db = this.admin.getWritableDatabase();
    }
    public void guardar_usuario(Usuarios user)
    {
        ContentValues valores = new ContentValues();
        valores.put("clave",user.getClave());
        valores.put("nombre",user.getNombre());
        valores.put("cedula",user.getCedula());
        valores.put("estado","ACTIVO");
        this.db.insert("usuario",null,valores);
        this.db.close();
    }
    public ArrayList<Usuarios> listar_todo(){
        Cursor row = this.db.rawQuery("",null);
        ArrayList<Usuarios>lista = new ArrayList<>();
        if(row.moveToFirst()){
            do {
                Usuarios obj = new Usuarios();
                obj.setClave(row.getString(1));
                obj.setNombre(row.getString(2));
                obj.setCedula(row.getString(3));
                obj.setIdusuarios(row.getInt(0));
                lista.add(obj);
            }while(row.moveToNext());
        }
        return lista;
    }
}
