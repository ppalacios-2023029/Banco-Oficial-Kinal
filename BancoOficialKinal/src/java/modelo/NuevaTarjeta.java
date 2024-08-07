package modelo;

import java.io.InputStream;

public class NuevaTarjeta {
    int codigoNuevaTarjeta;
    String titulo;
    InputStream imagen;
    String descripcion;
    double monto;

    public NuevaTarjeta() {
    }

    public NuevaTarjeta(int codigoNuevaTarjeta, String titulo, InputStream imagen, String descripcion, double monto) {
        this.codigoNuevaTarjeta = codigoNuevaTarjeta;
        this.titulo = titulo;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.monto = monto;
    }

    

    public int getCodigoNuevaTarjeta() {
        return codigoNuevaTarjeta;
    }

    public void setCodigoNuevaTarjeta(int codigoNuevaTarjeta) {
        this.codigoNuevaTarjeta = codigoNuevaTarjeta;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public InputStream getImagen() {
        return imagen;
    }

    public void setImagen(InputStream imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
         
    
    
}
