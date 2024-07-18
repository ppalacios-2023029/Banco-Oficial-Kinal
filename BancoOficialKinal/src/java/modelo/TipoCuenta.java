package modelo;

public class TipoCuenta {
    private int codigoTipoCuenta;
    private String tipoCuenta;
    private double saldoMinimoRequerido;
    private double tazaDeInteres;
    private double tazaDeImpuestos;
    private String estado;

    public TipoCuenta() {
    }

    public TipoCuenta(int codigoTipoCuenta, String tipoCuenta, double saldoMinimoRequerido, double tazaDeInteres, double tazaDeImpuestos, String estado) {
        this.codigoTipoCuenta = codigoTipoCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldoMinimoRequerido = saldoMinimoRequerido;
        this.tazaDeInteres = tazaDeInteres;
        this.tazaDeImpuestos = tazaDeImpuestos;
        this.estado = estado;
    }
    
    

    public int getCodigoTipoCuenta() {
        return codigoTipoCuenta;
    }

    public void setCodigoTipoCuenta(int codigoTipoCuenta) {
        this.codigoTipoCuenta = codigoTipoCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public double getSaldoMinimoRequerido() {
        return saldoMinimoRequerido;
    }

    public void setSaldoMinimoRequerido(double saldoMinimoRequerido) {
        this.saldoMinimoRequerido = saldoMinimoRequerido;
    }

    public double getTazaDeInteres() {
        return tazaDeInteres;
    }

    public void setTazaDeInteres(double tazaDeInteres) {
        this.tazaDeInteres = tazaDeInteres;
    }

    public double getTazaDeImpuestos() {
        return tazaDeImpuestos;
    }

    public void setTazaDeImpuestos(double tazaDeImpuestos) {
        this.tazaDeImpuestos = tazaDeImpuestos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
