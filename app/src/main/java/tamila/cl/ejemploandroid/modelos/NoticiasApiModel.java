package tamila.cl.ejemploandroid.modelos;

import com.google.gson.annotations.SerializedName;

public class NoticiasApiModel {
    @SerializedName("id")
    private int id;
    @SerializedName("titulo")
    private String titulo;
    @SerializedName("bajada")
    private String bajada;
    @SerializedName("fecha")
    private String fecha;
    @SerializedName("foto")
    private String foto;

    public NoticiasApiModel(int id, String titulo, String bajada, String fecha, String foto) {

        this.id = id;
        this.titulo = titulo;
        this.bajada = bajada;
        this.fecha = fecha;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getBajada() {
        return bajada;
    }

    public void setBajada(String bajada) {
        this.bajada = bajada;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
