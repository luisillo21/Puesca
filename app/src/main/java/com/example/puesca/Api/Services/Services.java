package com.example.puesca.Api.Services;

import com.example.puesca.Model.Persona;
import com.example.puesca.Model.TipoServicio;
import com.example.puesca.Model.Usuarios;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Services {
    @GET("webservices/trunk/Proyecto_Facturas/get_all_usuario.php")
    Call<Usuarios> getUsuario(@Query("usuario") String usuario);

    @GET("webservices/trunk/Proyecto_Facturas/get_all_usuario.php")
    Call<TipoServicio> getTipoServicio();

    @GET("webservices/trunk/Proyecto_Facturas/get_all_usuario.php")
    Call<Persona> getpersona();
}
