package tamila.cl.ejemploandroid.retrofit;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import tamila.cl.ejemploandroid.R;
import tamila.cl.ejemploandroid.retrofit.modelos.Contactos;

public class AdapterContactos extends RecyclerView.Adapter<AdapterContactos.MyViewHolder>
{
    private List<Contactos> contactos;
    private Activity activity;
    private Context context;

    public AdapterContactos (List<Contactos> contactos,Activity activity)
    {
        this.contactos=contactos;
        this.activity=activity;
    }
    public AdapterContactos(List<Contactos> contactos,Context context)
    {
        this.contactos=contactos;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.id.setText(contactos.get(position).getId());
        holder.nombre.setText(contactos.get(position).getNombre());
        holder.correo.setText(contactos.get(position).getCorreo());
        //Picasso.with(this.activity).load(contactos.get(position).getFoto()).into(holder.foto);
        Glide.with(this.context).load(contactos.get(position).getFoto()).into(holder.foto);
    }

    @Override
    public int getItemCount() {
        return this.contactos.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView id,nombre,correo;
        ImageView foto;

        public MyViewHolder(View itemView) {
            super(itemView);
            id=(TextView)itemView.findViewById(R.id.id);
            nombre=(TextView)itemView.findViewById(R.id.nombre);
            correo=(TextView)itemView.findViewById(R.id.correo);
            foto=(ImageView)itemView.findViewById(R.id.foto);
        }
    }

}
