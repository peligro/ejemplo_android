package tamila.cl.ejemploandroid.vistas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import tamila.cl.ejemploandroid.R;
import tamila.cl.ejemploandroid.adaptadores.TarjetasApiAdapter;
import tamila.cl.ejemploandroid.constantes.Constantes;
import tamila.cl.ejemploandroid.modelos.NoticiasApiModel;
import tamila.cl.ejemploandroid.singleton.MySingleton;

public class VolleyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
        showToolbar("Ejemplo Volley",true);
        showRecyclerView();
    }

    public void showRecyclerView() {
        final ArrayList<NoticiasApiModel> arrayList=new ArrayList<>();
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.TarjetaRecycleView2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest
                (
                        Request.Method.GET,
                        Constantes.SERVICIO,
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                int count=0;
                                while(count<response.length())
                                {
                                    try
                                    {
                                        JSONObject jsonObject=response.getJSONObject(count);
                                        NoticiasApiModel noticiasApiModel=new NoticiasApiModel
                                                (
                                                        jsonObject.getInt("id"),
                                                        jsonObject.getString("titulo"),
                                                        jsonObject.getString("bajada"),
                                                        jsonObject.getString("fecha"),
                                                        jsonObject.getString("foto")
                                                );

                                        arrayList.add(noticiasApiModel);
                                        TarjetasApiAdapter tarjetasApiAdapter=new TarjetasApiAdapter(arrayList,VolleyActivity.this);
                                        recyclerView.setAdapter(tarjetasApiAdapter);
                                    count++;
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        NetworkResponse networkResponse = error.networkResponse;
                        String jsonError="nada";
                        if (networkResponse != null && networkResponse.data != null) {
                            jsonError = new String(networkResponse.data);
                            // Print Error!
                        }
                        Log.d( "error volley cesar: ", ""+jsonError);
                    }
                }
                )
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headersSys = super.getHeaders();
                Map<String, String> headers = new HashMap<String, String>();
                headers.put("Token", "123456 ");
                headers.putAll(headersSys);
                return headers;
            }
        };
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonArrayRequest);
    }
    public void showToolbar(String tittle, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

    }
}
