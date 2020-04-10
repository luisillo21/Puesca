package com.example.puesca.Api.Services;

import com.example.puesca.Model.Persona;
import com.example.puesca.Model.PersonaSerializers;
import com.example.puesca.Model.TipoServicio;
import com.example.puesca.Model.TipoServicioSerializers;
import com.example.puesca.Model.Usuarios;
import com.example.puesca.Model.UsuariosSerializer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Services {
    @GET("webservices/trunk/Proyecto_Facturas/get_all_usuario.php")
    Call<UsuariosSerializer> getUsuario(@Query("usuario") String usuario);
    @GET("webservices/trunk/Proyecto_Facturas/get_all_usuario.php")
    Call<UsuariosSerializer> getUsuario();

    @GET("webservices/trunk/Proyecto_Facturas/get_all_usuario.php")
    Call<TipoServicioSerializers> getTipoServicio();

    @GET("webservices/trunk/Proyecto_Facturas/get_all_usuario.php")
    Call<PersonaSerializers> getpersona();
}
