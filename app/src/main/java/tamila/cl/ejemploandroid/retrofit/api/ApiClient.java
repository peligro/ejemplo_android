package tamila.cl.ejemploandroid.retrofit.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tamila.cl.ejemploandroid.constantes.Constantes;

public class ApiClient
{


    public static Retrofit getAPiClient()
    {
        if (Constantes.retrofit==null)
        {
            Constantes.retrofit=new Retrofit.Builder().baseUrl(Constantes.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return Constantes.retrofit;
    }
}

