package com.example.puesca.Adapter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.puesca.Database.DbCliente;
import com.example.puesca.Model.Persona;
import com.example.puesca.R;

import java.util.ArrayList;

public class PersonaClienteAdapter extends BaseAdapter {
    ArrayList<Persona> personas;
    Context context;

    public PersonaClienteAdapter(ArrayList<Persona> personas, Context context) {
        this.personas = personas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return personas.size();
    }

    @Override
    public Object getItem(int position) {
        return personas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.item_cliente_activity,null);
        TextView nombre =  (TextView)v.findViewById(R.id.usuario_item);
        TextView servicio = (TextView)v.findViewById(R.id.servicio_item);

        DbCliente admin = new DbCliente(context,"cliente",null,1);
        SQLiteDatabase db = admin.getReadableDatabase();
        Cursor row = db.rawQuery("SELECT * FROM tipo_servicio where idtipo_servicio="+personas.get(position).getIdtipo(),null);
        nombre.setText(personas.get(position).getNombre());
        if(row.moveToFirst()){
            servicio.setText(String.valueOf(row.getInt(1)));
        }
        return v;
    }
}
