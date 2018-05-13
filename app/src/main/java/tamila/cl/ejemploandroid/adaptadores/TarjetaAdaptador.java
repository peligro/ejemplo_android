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
import tamila.cl.ejemploandroid.modelos.NoticiaModel;

public class TarjetaAdaptador extends RecyclerView.Adapter<TarjetaAdaptador.MyViewHolder>
{
    private List<NoticiaModel> noticias;
    private Activity activity;

    public TarjetaAdaptador(List<NoticiaModel> noticias, Activity activity)
    {
        this.noticias=noticias;
        this.activity=activity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, final int position)
    {
        holder.tarjeta_titulo.setText(noticias.get(position).getTitulo());
        holder.tarjeta_detalle.setText(noticias.get(position).getTitulo());
        Picasso.with(this.activity).load(noticias.get(position).getImagen()).into(holder.tarjeta_imagen);
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
        return this.noticias.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        private TextView tarjeta_titulo,tarjeta_detalle;
        private ImageView tarjeta_imagen;
        public MyViewHolder(View view)
        {
            super(view);
            tarjeta_imagen=(ImageView)view.findViewById(R.id.tarjeta_imagen);
            tarjeta_titulo=(TextView)view.findViewById(R.id.tarjeta_titulo);
            tarjeta_detalle=(TextView)view.findViewById(R.id.tarjeta_detalle);
        }

    }
}
