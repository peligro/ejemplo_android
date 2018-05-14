package tamila.cl.ejemploandroid.vistas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import tamila.cl.ejemploandroid.R;

public class MapaActivity extends AppCompatActivity  implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        showToolbar("Ejemplo Mapa",true);
        showMapa();


    }
    public void showMapa()
    {
        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    public void showToolbar(String tittle, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng ubicacion = new LatLng(-33.4482471, -70.6363843);
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        float zoomLevel = 16.0f; //This goes up to 21
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacion, zoomLevel));
        googleMap.addMarker(new MarkerOptions().position(ubicacion).title("Estoy aquí"));
    }
}
