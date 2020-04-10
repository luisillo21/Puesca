package com.example.puesca.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.puesca.Api.Api;
import com.example.puesca.Api.Deserializers.PersonaDeserializers;
import com.example.puesca.Api.Deserializers.TipoServicioDeserializers;
import com.example.puesca.Api.Deserializers.UsuarioDeserializers;
import com.example.puesca.Api.Services.Services;
import com.example.puesca.DAO.PersonaDao;
import com.example.puesca.DAO.TipoServicioDao;
import com.example.puesca.DAO.UsuarioDao;
import com.example.puesca.Database.DbCliente;
import com.example.puesca.Model.Persona;
import com.example.puesca.Model.PersonaSerializers;
import com.example.puesca.Model.TipoServicioSerializers;
import com.example.puesca.Model.UsuariosSerializer;
import com.example.puesca.R;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText user;
    private EditText password;
    private TextView registro;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText) findViewById(R.id.editUser);
        password = (EditText)findViewById(R.id.editPassword);
        button = (Button)findViewById(R.id.btnLogin);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = user.getText().toString();
                String clave = password.getText().toString();
                DbCliente admin = new DbCliente(MainActivity.this,"cliente",null,1);
                SQLiteDatabase db = admin.getReadableDatabase();
                Cursor row = db.rawQuery("SELECT clave FROM usuario where usuario",null);
                if(row.moveToFirst()){
                    if(clave.equals(row.getString(0))){
                        Intent intent = new Intent(MainActivity.this,ListarCliente_Activity.class);
                        startActivity(intent);
                        Toast.makeText(MainActivity.this,"Usuario Ingresado",Toast.LENGTH_SHORT).show();
                        finish();
                    }else{
                        Toast.makeText(MainActivity.this,"Usuario o Contraseña incorrecta",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    traer_datos();
                }
            }
        });

    }
    public void traer_datos(){
        final GsonBuilder builder = new GsonBuilder().setLenient();
        builder.registerTypeAdapter(PersonaSerializers.class,new PersonaDeserializers());
        Api.retrofit = null;
        Services serv = Api.getAPI(builder).create(Services.class);
        Call<PersonaSerializers> datos = serv.getpersona();
        datos.enqueue(new Callback<PersonaSerializers>() {
            @Override
            public void onResponse(Call<PersonaSerializers> call, Response<PersonaSerializers> response) {
                if(response.isSuccessful()){
                    PersonaSerializers persona = response.body();
                    for (int i = 0;i<persona.getPersona().size();i++){
                        Log.e("ERROR DE ROLES","LO QUE TE ESTA TRAYENDO ES: "+response.body().getPersona().get(i).getNombre().toString());
                        PersonaDao dao = new PersonaDao(MainActivity.this);
                        dao.guardar_persona(persona.getPersona().get(i));
                    }
                }
            }

            @Override
            public void onFailure(Call<PersonaSerializers> call, Throwable t) {
                Toast.makeText(MainActivity.this,"NO ESTA TRAYENDO LA INFORMACION",Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
        builder.registerTypeAdapter(UsuariosSerializer.class,new UsuarioDeserializers());
        Api.retrofit = null;
        serv = Api.getAPI(builder).create(Services.class);
        Call<UsuariosSerializer> data = serv.getUsuario();
        data.enqueue(new Callback<UsuariosSerializer>() {
            @Override
            public void onResponse(Call<UsuariosSerializer> call, Response<UsuariosSerializer> response) {
                if(response.isSuccessful()){
                    UsuariosSerializer persona = response.body();
                    for (int i = 0;i<persona.getUser().size();i++){
                        Log.e("ERROR DE ROLES","LO QUE TE ESTA TRAYENDO ES: "+response.body().getUser().get(i).getNombre().toString());
                        UsuarioDao dao = new UsuarioDao(MainActivity.this);
                        dao.guardar_usuario(persona.getUser().get(i));
                    }
                }
            }

            @Override
            public void onFailure(Call<UsuariosSerializer> call, Throwable t) {
                Toast.makeText(MainActivity.this,"NO ESTA TRAYENDO LA INFORMACION",Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });

        builder.registerTypeAdapter(TipoServicioSerializers.class,new TipoServicioDeserializers());
        Api.retrofit = null;
        serv = Api.getAPI(builder).create(Services.class);
        Call<TipoServicioSerializers> por = serv.getTipoServicio();
        por.enqueue(new Callback<TipoServicioSerializers>() {
            @Override
            public void onResponse(Call<TipoServicioSerializers> call, Response<TipoServicioSerializers> response) {
                if(response.isSuccessful()){
                    TipoServicioSerializers persona = response.body();
                    for (int i = 0;i<persona.getTipo().size();i++){
                        Log.e("ERROR DE ROLES","LO QUE TE ESTA TRAYENDO ES: "+response.body().getTipo().get(i).getServicio().toString());
                        TipoServicioDao dao = new TipoServicioDao(MainActivity.this);
                        dao.guardar_tipo(persona.getTipo().get(i));
                    }
                }
            }

            @Override
            public void onFailure(Call<TipoServicioSerializers> call, Throwable t) {
                Toast.makeText(MainActivity.this,"NO ESTA TRAYENDO LA INFORMACION",Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
        builder.registerTypeAdapter(UsuariosSerializer.class,new UsuarioDeserializers());
        Api.retrofit = null;
        serv = Api.getAPI(builder).create(Services.class);
        Call<UsuariosSerializer> datas = serv.getUsuario(user.getText().toString());
        data.enqueue(new Callback<UsuariosSerializer>() {
            @Override
            public void onResponse(Call<UsuariosSerializer> call, Response<UsuariosSerializer> response) {
                if(response.isSuccessful()){
                    UsuariosSerializer persona = response.body();
                    for (int i = 0;i<persona.getUser().size();i++){
                        if(persona.getUser().get(i).getNombre().equals(user.getText().toString()) &&  persona.getUser().get(i).getClave().equals(password.getText().toString())){
                            Intent intent = new Intent(MainActivity.this,ListarCliente_Activity.class);
                            startActivity(intent);
                            finish();
                        }
                        else{
                            Toast.makeText(MainActivity.this,"Usuario O contraseña incorrecta",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<UsuariosSerializer> call, Throwable t) {
                Toast.makeText(MainActivity.this,"NO ESTA TRAYENDO LA INFORMACION",Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });







    }
}
