package tamila.cl.ejemploandroid.adaptadores;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import tamila.cl.ejemploandroid.R;
import tamila.cl.ejemploandroid.modelos.NoticiasApiModel;

public class TarjetasApiAdapter extends   RecyclerView.Adapter<TarjetasApiAdapter.Envolver>
{
    private List<NoticiasApiModel> noticias;
    private Activity activity;

    public TarjetasApiAdapter(List<NoticiasApiModel> noticias, Activity activity) {
        this.noticias = noticias;
        this.activity=activity;
    }

    @NonNull
    @Override
    public Envolver onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta_volley,parent,false);
        return new Envolver(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Envolver holder, final int position) {
        holder.tarjeta_titulo.setText(noticias.get(position).getTitulo());
        holder.tarjeta_detalle.setText(noticias.get(position).getBajada());
        Picasso.with(this.activity).load(noticias.get(position).getFoto()).into(holder.tarjeta_imagen);
        //se agrega un click a la imagen
        holder.tarjeta_imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity.getApplicationContext(),"se hizo click en la foto: "+noticias.get(position).getTitulo(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return noticias.size();
    }

    public static class Envolver extends RecyclerView.ViewHolder
    {
        private TextView tarjeta_titulo,tarjeta_detalle;
        private ImageView tarjeta_imagen;
        public Envolver(View view)
        {
            super(view);
            tarjeta_imagen=(ImageView)view.findViewById(R.id.tarjeta_imagen);
            tarjeta_titulo=(TextView)view.findViewById(R.id.tarjeta_titulo);
            tarjeta_detalle=(TextView)view.findViewById(R.id.tarjeta_detalle);
        }
    }
}
