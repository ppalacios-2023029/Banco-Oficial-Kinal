package modelo;

public class Carrito {
    int item; 
    int idNuevaTargeta;
    String titulo;
    String descripcion;
    double monto;
    int cantidad;
    double subTotal;

    public Carrito() {
    }

    public Carrito(int item, int idNuevaTargeta, String titulo, String descripcion, double monto, int cantidad, double subTotal) {
        this.item = item;
        this.idNuevaTargeta = idNuevaTargeta;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.monto = monto;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getIdNuevaTargeta() {
        return idNuevaTargeta;
    }

    public void setIdNuevaTargeta(int idNuevaTargeta) {
        this.idNuevaTargeta = idNuevaTargeta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
    
    
    
}
