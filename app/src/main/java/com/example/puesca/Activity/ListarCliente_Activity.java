package com.example.puesca.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.puesca.Adapter.PersonaClienteAdapter;
import com.example.puesca.DAO.PersonaDao;
import com.example.puesca.Model.Persona;
import com.example.puesca.R;

import java.util.ArrayList;
import java.util.List;

public class ListarCliente_Activity extends AppCompatActivity {
    ListView lista;
    PersonaClienteAdapter adapter;
    ArrayList<Persona> lista_persona;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_cliente_);

        lista = (ListView)findViewById(R.id.listview_detalle);
        lista_persona = new ArrayList<>();
        PersonaDao dao = new PersonaDao(ListarCliente_Activity.this);
        lista_persona = dao.listar_persona();
        adapter = new PersonaClienteAdapter(lista_persona,ListarCliente_Activity.this);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Persona obj = lista_persona.get(position);
                Intent intent = new Intent(ListarCliente_Activity.this,Actualizar_Cliente_activity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("persona",obj);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });


    }
}
