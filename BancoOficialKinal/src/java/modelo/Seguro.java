package modelo;

import java.util.Date;

public class Seguro {
    private int numeroSeguro;
    private String numeroPoliza;
    private String tipoSeguro;
    private double montoAsegurado;
    private double primaMensual;
    private Date fechaExpiracion;
    private String estado;
    private int codigoCliente;

    public Seguro() {
    }

    public Seguro(int numeroSeguro, String numeroPoliza, String tipoSeguro, double montoAsegurado, double primaMensual, Date fechaExpiracion, String estado, int codigoCliente) {
        this.numeroSeguro = numeroSeguro;
        this.numeroPoliza = numeroPoliza;
        this.tipoSeguro = tipoSeguro;
        this.montoAsegurado = montoAsegurado;
        this.primaMensual = primaMensual;
        this.fechaExpiracion = fechaExpiracion;
        this.estado = estado;
        this.codigoCliente = codigoCliente;
    }

    public int getNumeroSeguro() {
        return numeroSeguro;
    }

    public void setNumeroSeguro(int numeroSeguro) {
        this.numeroSeguro = numeroSeguro;
    }

    public String getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(String numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public String getTipoSeguro() {
        return tipoSeguro;
    }

    public void setTipoSeguro(String tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }

    public double getMontoAsegurado() {
        return montoAsegurado;
    }

    public void setMontoAsegurado(double montoAsegurado) {
        this.montoAsegurado = montoAsegurado;
    }

    public double getPrimaMensual() {
        return primaMensual;
    }

    public void setPrimaMensual(double primaMensual) {
        this.primaMensual = primaMensual;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
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
