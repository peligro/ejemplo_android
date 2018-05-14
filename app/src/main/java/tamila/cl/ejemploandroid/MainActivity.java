package tamila.cl.ejemploandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import tamila.cl.ejemploandroid.vistas.CardViewActivity;
import tamila.cl.ejemploandroid.vistas.GPSActivity;
import tamila.cl.ejemploandroid.vistas.MapaActivity;
import tamila.cl.ejemploandroid.vistas.MapaGooleActivity;
import tamila.cl.ejemploandroid.vistas.MenuDrawerActivity;
import tamila.cl.ejemploandroid.vistas.PicassoActivity;
import tamila.cl.ejemploandroid.vistas.RetrofitActivity;
import tamila.cl.ejemploandroid.vistas.VolleyActivity;
import tamila.cl.ejemploandroid.vistas.WebViewActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void boton_1(View view)
    {
        startActivity(new Intent(this, CardViewActivity.class));
    }
    public void boton_2(View view)
    {
        startActivity(new Intent(this, PicassoActivity.class));
    }
    public void boton_3(View view)
    {
        startActivity(new Intent(this, WebViewActivity.class));
    }
    public void boton_4(View view)
    {
        startActivity(new Intent(this, MapaGooleActivity.class));
    }
    public void boton_5(View view)
    {
        startActivity(new Intent(this, VolleyActivity.class));
    }
    public void boton_6(View view)
    {
        startActivity(new Intent(this, RetrofitActivity.class));
    }
    public void boton_7(View view)
    {
        startActivity(new Intent(this, MenuDrawerActivity.class));
    }
    public void boton_8(View view)
    {
        startActivity(new Intent(this, MapaActivity.class));
    }
    public void boton_9(View view)
    {
        startActivity(new Intent(this, GPSActivity.class));
    }
}
