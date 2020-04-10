package com.example.puesca.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.puesca.DAO.PersonaDao;
import com.example.puesca.DAO.TipoServicioDao;
import com.example.puesca.Database.DbCliente;
import com.example.puesca.Model.Persona;
import com.example.puesca.Model.TipoServicio;
import com.example.puesca.Model.Usuarios;
import com.example.puesca.R;

import java.util.ArrayList;

public class Actualizar_Cliente_activity extends AppCompatActivity {
    EditText editnombre,editapellido,editcedula,editProvincia,editContacto,editFecha;
    Spinner editTipo;
    TextView id_tipo,string;
    Button btn_registrar;

    ArrayList<TipoServicio> servicio;
    ArrayList<String> listServicio;
    Persona persona;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar__cliente_activity);

        final Bundle bundle = getIntent().getExtras();
        persona = new Persona();

        if (bundle != null){
            persona = (Persona) bundle.getSerializable("persona");
        }




        editnombre = (EditText) findViewById(R.id.editNombre);
        editapellido = (EditText) findViewById(R.id.editApellido);
        editcedula = (EditText) findViewById(R.id.editCedula);
        editProvincia = (EditText) findViewById(R.id.editProvincia);
        editContacto = (EditText) findViewById(R.id.editContacto);
        editFecha = (EditText) findViewById(R.id.editFecha);
        btn_registrar = (Button)findViewById(R.id.btn_editar);
        id_tipo = (TextView)findViewById(R.id.etaTipo);
        string = (TextView)findViewById(R.id.etActivityTipo);

        editTipo = (Spinner) findViewById(R.id.editTipo);
        consultarTipo();
        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(Actualizar_Cliente_activity.this,android.R.layout.simple_spinner_item,servicio);
        editTipo.setAdapter(adaptador);

        editnombre.setText(String.valueOf(persona.getNombre()));
        editapellido.setText(String.valueOf(persona.getApellido()));
        editcedula.setText(String.valueOf(persona.getApellido()));
        editProvincia.setText(String.valueOf(persona.getProvincia()));
        editContacto.setText(String.valueOf(persona.getProvincia()));
        editFecha.setText(String.valueOf(persona.getFecha_activacion()));

        editTipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position!=0){
                    id_tipo.setText(String.valueOf(servicio.get(position-1).getIdtipo_servicio()));
                    string.setText(String.valueOf(servicio.get(position-1).getServicio()));
                }else{
                    id_tipo.setText("");
                    string.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Persona persona = new Persona();
                persona.setNombre(editnombre.getText().toString());
                persona.setApellido(editapellido.getText().toString());
                persona.setCedula(editcedula.getText().toString());
                persona.setContacto(editContacto.getText().toString());
                persona.setFecha_activacion(editFecha.getText().toString());
                persona.setProvincia(editProvincia.getText().toString());
                persona.setIdtipo(Integer.valueOf(id_tipo.getText().toString()));
                PersonaDao dao = new PersonaDao(Actualizar_Cliente_activity.this);
                dao.guardar_persona(persona);
            }
        });

    }

    public void consultarTipo(){
        servicio = new ArrayList<>();
        TipoServicioDao dao = new TipoServicioDao(Actualizar_Cliente_activity.this);
        servicio = dao.listar_todo();
        obtenerListaActividad();
    }

    public void obtenerListaActividad(){
        listServicio = new ArrayList<String>();
        listServicio.add("Seleccione");
        for (int i = 0; i<servicio.size();i++ ){
            listServicio.add( servicio.get(i).getServicio());
        }
    }


}
