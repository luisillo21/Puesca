package com.example.puesca.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbCliente extends SQLiteOpenHelper {
    public DbCliente(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS usuario (" +
                "  idusuario integer PRIMARY KEY  AUTOINCREMENT NOT NULL ," +
                "  clave text NOT NULL," +
                "nombre text NOT NULL," +
                "cedula text not null," +
                "estado text not null," +
                "id_base integer" +
                ")");
        db.execSQL("CREATE TABLE IF NOT EXISTS tipo_servicio (" +
                "  idtipo_servicio integer PRIMARY KEY  AUTOINCREMENT NOT NULL ," +
                "  servicio text NOT NULL," +
                "estado text NOT NULL," +
                "id_base integer" +

                ")");
        db.execSQL("CREATE TABLE IF NOT EXISTS persona (" +
                "  idpersona integer PRIMARY KEY  AUTOINCREMENT NOT NULL ," +
                "  nombre text NOT NULL," +
                "apellido text NOT NULL," +
                "cedula text NOT NULL," +
                "provincia text NOT NULL," +
                "contacto text NOT NULL," +
                "estado text NOT NULL," +
                "id_base integer," +
                "idtipo integer not null," +
                "idusuario integer not null," +
                "FOREIGN KEY (idusuario)REFERENCES usuario(idusuario)," +
                "FOREIGN KEY(idtipo) REFERENCES tipo_servicio(idtipo_servicio)" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
