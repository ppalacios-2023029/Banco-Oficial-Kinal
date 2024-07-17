package modelo;

public class Sucursales {
    private int codigoSucursal;
    private String nombreSucursal;
    private String direccionSucursal;
    private String telefono;
    private String correoSucursal;
    private int codigoEmpleado;

    public Sucursales() {
    }

    public Sucursales(int codigoSucursal, String nombreSucursal, String direccionSucursal, String telefono, String correoSucursal, int codigoEmpleado) {
        this.codigoSucursal = codigoSucursal;
        this.nombreSucursal = nombreSucursal;
        this.direccionSucursal = direccionSucursal;
        this.telefono = telefono;
        this.correoSucursal = correoSucursal;
        this.codigoEmpleado = codigoEmpleado;
    }

    public int getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(int codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getDireccionSucursal() {
        return direccionSucursal;
    }

    public void setDireccionSucursal(String direccionSucursal) {
        this.direccionSucursal = direccionSucursal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoSucursal() {
        return correoSucursal;
    }

    public void setCorreoSucursal(String correoSucursal) {
        this.correoSucursal = correoSucursal;
    }

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }
    
    
}
