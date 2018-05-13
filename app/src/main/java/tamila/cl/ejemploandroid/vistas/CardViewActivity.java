package tamila.cl.ejemploandroid.vistas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import tamila.cl.ejemploandroid.R;
import tamila.cl.ejemploandroid.adaptadores.TarjetaAdaptador;
import tamila.cl.ejemploandroid.modelos.NoticiaModel;

public class CardViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
        showToolbar("Ejemplo Card View",true);
        showRecyclerView();
    }
    public void showRecyclerView()
    {
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.TarjetaRecycleView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        TarjetaAdaptador tarjetaAdaptador=new TarjetaAdaptador(getDatos(),this);
        recyclerView.setAdapter(tarjetaAdaptador);

    }
    public ArrayList<NoticiaModel> getDatos()
    {
        ArrayList<NoticiaModel> datos =new ArrayList<>();
        datos.add(new NoticiaModel("Título 1","https://www.manosenelcodigo.com/public/news/cursos/php.jpg","Texto detalle 1"));
        datos.add(new NoticiaModel("Título 2","https://www.manosenelcodigo.com/public/news/cursos/php.jpg","Texto detalle 2"));
        datos.add(new NoticiaModel("Título 3","https://www.manosenelcodigo.com/public/news/cursos/php.jpg","Texto detalle 3"));
        datos.add(new NoticiaModel("Título 4","https://www.manosenelcodigo.com/public/news/cursos/php.jpg","Texto detalle 4"));
        datos.add(new NoticiaModel("Título 5","https://www.manosenelcodigo.com/public/news/cursos/php.jpg","Texto detalle 5"));
        datos.add(new NoticiaModel("Título 6","https://www.manosenelcodigo.com/public/news/cursos/php.jpg","Texto detalle 6"));
        datos.add(new NoticiaModel("Título 7","https://www.manosenelcodigo.com/public/news/cursos/php.jpg","Texto detalle 7"));
        datos.add(new NoticiaModel("Título 8","https://www.manosenelcodigo.com/public/news/cursos/php.jpg","Texto detalle 8"));
        return datos;
    }
    public void showToolbar(String tittle, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

    }
}
