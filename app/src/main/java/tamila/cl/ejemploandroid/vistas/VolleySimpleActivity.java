package tamila.cl.ejemploandroid.vistas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import tamila.cl.ejemploandroid.R;
import tamila.cl.ejemploandroid.constantes.Constantes;
import tamila.cl.ejemploandroid.singleton.MySingleton;

public class VolleySimpleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_simple);
        showToolbar("Volley Simple",true);
        showVolley();
    }

    public void showVolley()
    {
        final TextView texto_volley=(TextView)findViewById(R.id.texto_volley);
        StringRequest stringRequest=new StringRequest
                (
                        Request.Method.GET,
                        Constantes.SIMPLE,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                //Toast.makeText(getApplicationContext(),"response="+response,Toast.LENGTH_LONG).show();
                                texto_volley.setText(response);
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
                ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headersSys = super.getHeaders();
                Map<String, String> headers = new HashMap<String, String>();
                headers.put("Token", "123456 ");
                headers.putAll(headersSys);
                return headers;
            }
        };
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }
    public void showToolbar(String tittle, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

    }
}
