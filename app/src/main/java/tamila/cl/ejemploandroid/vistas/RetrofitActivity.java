package tamila.cl.ejemploandroid.vistas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tamila.cl.ejemploandroid.R;
import tamila.cl.ejemploandroid.retrofit.AdapterContactos;
import tamila.cl.ejemploandroid.retrofit.api.ApiClient;
import tamila.cl.ejemploandroid.retrofit.interfaces.ApiInterface;
import tamila.cl.ejemploandroid.retrofit.modelos.Contactos;

public class RetrofitActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private List<Contactos> contactos;
    private ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        showToolbar("Ejemplo Retrofit",true);
        showEjemplo();
    }
    public void showEjemplo()
    {
        recyclerView=(RecyclerView)findViewById(R.id.TarjetaRecycleView);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        apiInterface= ApiClient.getAPiClient().create(ApiInterface.class);
        Call<List<Contactos>> call = apiInterface.getContactos();
        call.enqueue(new Callback<List<Contactos>>() {
            @Override
            public void onResponse(Call<List<Contactos>> call, Response<List<Contactos>> response) {
                contactos=response.body();
                adapter=new AdapterContactos(contactos,getApplicationContext()   );
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Contactos>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"ocurrió un error",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void showToolbar(String tittle, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

    }
}
