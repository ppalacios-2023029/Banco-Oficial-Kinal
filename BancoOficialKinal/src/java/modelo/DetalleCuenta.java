package modelo;

import java.util.Date;

public class DetalleCuenta {
    private int codigoDetalleCuenta;
    private Date fechaDetalle;
    private String tipoOperacion;
    private String estadoCuenta;
    private int codigoCliente;
    private int codigoEmpleado;
    private int codigoSucursal;

    public DetalleCuenta() {
    }

    public DetalleCuenta(int codigoDetalleCuenta, Date fechaDetalle, String tipoOperacion, String estadoCuenta, int codigoCliente, int codigoEmpleado, int codigoSucursal) {
        this.codigoDetalleCuenta = codigoDetalleCuenta;
        this.fechaDetalle = fechaDetalle;
        this.tipoOperacion = tipoOperacion;
        this.estadoCuenta = estadoCuenta;
        this.codigoCliente = codigoCliente;
        this.codigoEmpleado = codigoEmpleado;
        this.codigoSucursal = codigoSucursal;
    }

    public int getCodigoDetalleCuenta() {
        return codigoDetalleCuenta;
    }

    public void setCodigoDetalleCuenta(int codigoDetalleCuenta) {
        this.codigoDetalleCuenta = codigoDetalleCuenta;
    }

    public Date getFechaDetalle() {
        return fechaDetalle;
    }

    public void setFechaDetalle(Date fechaDetalle) {
        this.fechaDetalle = fechaDetalle;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public String getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(String estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public int getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(int codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }
    
    
}
