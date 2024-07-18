package modelo;

import java.util.Date;

public class PagoPrestamo {
    private int codigoPagos;
    private double monto;
    private Date fechaInicio;
    private Date fechaVencimiento;
    private String estadoPago;
    private int codigoPrestamo;
    private String estado;

    public PagoPrestamo(int codigoPagos, double monto, Date fechaInicio, Date fechaVencimiento, String estadoPago, int codigoPrestamo, String estado) {
        this.codigoPagos = codigoPagos;
        this.monto = monto;
        this.fechaInicio = fechaInicio;
        this.fechaVencimiento = fechaVencimiento;
        this.estadoPago = estadoPago;
        this.codigoPrestamo = codigoPrestamo;
        this.estado = estado;
    }

    public int getCodigoPagos() {
        return codigoPagos;
    }

    public void setCodigoPagos(int codigoPagos) {
        this.codigoPagos = codigoPagos;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public int getCodigoPrestamo() {
        return codigoPrestamo;
    }

    public void setCodigoPrestamo(int codigoPrestamo) {
        this.codigoPrestamo = codigoPrestamo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    
}
