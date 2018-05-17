package tamila.cl.ejemploandroid.retrofit.interfaces;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

import tamila.cl.ejemploandroid.retrofit.modelos.Contactos;


public interface ApiInterface
{
    /*
    @Headers("Token: 123456")
    @GET("contactos")
    Call<List<Contactos>> getContactos();
    */


    @Headers("Token: 123456")
    @GET("contactos")
    Call<List<Contactos>> getContactos();
    //Call<List<Contactos>> getContactos(@Field("cantidad") String cantidad, @Field("correo") String correo);
}
