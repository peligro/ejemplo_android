package tamila.cl.ejemploandroid.retrofit.modelos;

import com.google.gson.annotations.SerializedName;

public class Contactos
{
    @SerializedName("id")
    private String id;
    @SerializedName("nombre")
    private String nombre;
    @SerializedName("correo")
    private String correo;
    @SerializedName("foto")
    private String foto;

    public Contactos(String id, String nombre, String correo, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.foto = foto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}