package com.example.puesca.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.puesca.Database.DbCliente;
import com.example.puesca.Model.TipoServicio;

import java.util.ArrayList;

public class TipoServicioDao {
    private DbCliente admin;
    private SQLiteDatabase db;

    public TipoServicioDao(Context context) {
        this.admin = new DbCliente(context,"cliente",null,1);
        this.db = this.admin.getWritableDatabase();
    }
    public void guardar_tipo(TipoServicio tipo){
        ContentValues valores = new ContentValues();
        valores.put("servicio",tipo.getServicio());
        valores.put("estado","ACTIVO");
        this.db.insert("tipo_servicio",null,valores);
        this.db.close();
    }
    public ArrayList<TipoServicio> listar_todo(){
        Cursor row = this.db.rawQuery("SELECT * FROM tipo_servicio",null);
        ArrayList<TipoServicio> lista = new ArrayList<>();
        if(row.moveToFirst()){
            do{
                TipoServicio obj = new TipoServicio();
                obj.setIdtipo_servicio(row.getInt(0));
                obj.setServicio(row.getString(1));
                lista.add(obj);
            }while(row.moveToNext());
        }
        return lista;
    }
}
