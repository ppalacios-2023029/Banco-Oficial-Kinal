package modelo;

import java.util.Date;

public class Transaccion {
    private int codigoTransaccion;
    private String estadoTransaccion;
    private String tipoTransaccion;
    private double monto;
    private Date fecha;
    private String estado;
    private int codigoCliente;

    public Transaccion() {
    }

    public Transaccion(int codigoTransaccion, String estadoTransaccion, String tipoTransaccion, double monto, Date fecha, String estado, int codigoCliente) {
        this.codigoTransaccion = codigoTransaccion;
        this.estadoTransaccion = estadoTransaccion;
        this.tipoTransaccion = tipoTransaccion;
        this.monto = monto;
        this.fecha = fecha;
        this.estado = estado;
        this.codigoCliente = codigoCliente;
    }

    public int getCodigoTransaccion() {
        return codigoTransaccion;
    }

    public void setCodigoTransaccion(int codigoTransaccion) {
        this.codigoTransaccion = codigoTransaccion;
    }

    public String getEstadoTransaccion() {
        return estadoTransaccion;
    }

    public void setEstadoTransaccion(String estadoTransaccion) {
        this.estadoTransaccion = estadoTransaccion;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
