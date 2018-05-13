package tamila.cl.ejemploandroid.modelos;

public class NoticiaModel {
    private String titulo;
    private String imagen;
    private String detalle;

    public NoticiaModel(String titulo, String imagen, String detalle) {
        this.titulo = titulo;
        this.imagen = imagen;
        this.detalle = detalle;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
