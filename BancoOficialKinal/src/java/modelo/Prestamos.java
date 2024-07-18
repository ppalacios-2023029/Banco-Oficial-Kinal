package modelo;

import java.util.Date;

public class Prestamos {
    private int codigoPrestamo;
    private double monto;
    private String tipoPrestamo;
    private double tasaInteres;
    private Date fechaInicio;
    private Date fechaVencimiento;
    private String estado;
    private int codigoCliente;

    public Prestamos() {
    }

    public Prestamos(int codigoPrestamo, double monto, String tipoPrestamo, double tasaInteres, Date fechaInicio, Date fechaVencimiento, String estado, int codigoCliente) {
        this.codigoPrestamo = codigoPrestamo;
        this.monto = monto;
        this.tipoPrestamo = tipoPrestamo;
        this.tasaInteres = tasaInteres;
        this.fechaInicio = fechaInicio;
        this.fechaVencimiento = fechaVencimiento;
        this.estado = estado;
        this.codigoCliente = codigoCliente;
    }

    

    public int getCodigoPrestamo() {
        return codigoPrestamo;
    }

    public void setCodigoPrestamo(int codigoPrestamo) {
        this.codigoPrestamo = codigoPrestamo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getTipoPrestamo() {
        return tipoPrestamo;
    }

    public void setTipoPrestamo(String tipoPrestamo) {
        this.tipoPrestamo = tipoPrestamo;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }
    
    
}
