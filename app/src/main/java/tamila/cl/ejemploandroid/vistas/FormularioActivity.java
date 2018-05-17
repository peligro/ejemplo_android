package tamila.cl.ejemploandroid.vistas;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import tamila.cl.ejemploandroid.R;
import tamila.cl.ejemploandroid.utilizades.Utilidades;
import tamila.cl.ejemploandroid.validaciones.Validaciones;

public class FormularioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        showToolbar("Formulario",true);
    }
    public void enviar(View view)
    {
        //se obtiene la referencia a cada campo
        EditText txt_nombre=(EditText)findViewById(R.id.txt_nombre);
        EditText txt_telefono=(EditText)findViewById(R.id.txt_telefono);
        EditText txt_correo=(EditText)findViewById(R.id.txt_correo);
        TextView resultado=(TextView)findViewById(R.id.resultado);
        final EditText txt_rut=(EditText)findViewById(R.id.txt_rut);
        txt_rut.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus)
                {
                    //Toast.makeText(getApplicationContext(), "rut rut", Toast.LENGTH_LONG).show();
                    txt_rut.setText(Utilidades.formateaRut(txt_rut.getText().toString()));
                }
            }
        });
        //se aplican validaciones
        Validaciones validaciones=new Validaciones();
        Integer bandera_nombre=0;
        Integer bandera_correo=0;
        Integer bandera_telefono=0;
        Integer bandera_rut=0;
        Integer bandera_rut_valido=0;
        String error="";
        if(validaciones.campoRequerido(txt_nombre)==false)
        {
            error+="El campo Nombre está vacío";
            bandera_nombre=1;
        }else
        {
            bandera_nombre=0;
        }
        if(validaciones.campoRequerido(txt_correo)==false)
        {
            error+="El campo E-Mail está vacío";
            bandera_correo=1;
        }else
        {
            bandera_correo=0;
        }
        if(validaciones.campoRequerido(txt_telefono)==false)
        {
            error+="El campo Teléfono está vacío";
            bandera_telefono=1;
        }else
        {
            bandera_telefono=0;
        }
        if(validaciones.campoRequerido(txt_rut)==false)
        {
            error+="El campo RUT está vacío";
            bandera_rut=1;
        }else
        {
            bandera_rut=0;
        }
        if(validaciones.validarRut(txt_rut.getText().toString())==false)
        {
            error+="EL RUT ingresado no es válido";
            bandera_rut_valido=1;
        }else
        {
            bandera_rut_valido=0;
        }
        if(bandera_rut_valido==1 || bandera_rut==1 || bandera_correo==1 || bandera_nombre==1 || bandera_telefono==1)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getResources().getString(R.string.app_name));
            builder.setMessage("Debe completar todos los campos");
            builder.setPositiveButton("OK",null);
            builder.create();
            builder.show();

            txt_nombre.setText("");
            txt_rut.setText("");
            txt_correo.setText("");
            txt_telefono.setText("");
        }else
            {
                final ProgressDialog progress = new ProgressDialog(this);
                progress.setTitle(getResources().getString(R.string.app_name));
                progress.setMessage("Cargando...");
                progress.show();

                Runnable progressRunnable = new Runnable() {

                    @Override
                    public void run() {
                        progress.cancel();
                    }
                };

                Handler pdCanceller = new Handler();
                pdCanceller.postDelayed(progressRunnable, 1000);

                resultado.setText("Nombre: "+txt_nombre.getText().toString()+"\nE-Mail="+txt_correo.getText().toString()+"\nTeléfono="+txt_telefono.getText().toString()+"\nRUT="+txt_rut.getText().toString());
            }
    }
    public void showToolbar(String tittle, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

    }
}
