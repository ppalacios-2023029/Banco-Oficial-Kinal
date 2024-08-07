package modelo;

import java.io.InputStream;

public class Empleado {
    private int codigoEmpleado;
    private String nombreEmpleado;
    private String apellidoEmpleado;
    private String usuario;
    private String contrasena;
    private String cargo;
    private double salario;
    private String oficina;
    private String estado;
    private int codigoCargoEmpleado;
    InputStream imagenUser;
    public Empleado() {
    }

    public Empleado(int codigoEmpleado, String nombreEmpleado, String apellidoEmpleado, String usuario, String contrasena, String cargo, double salario, String oficina, String estado, int codigoCargoEmpleado, InputStream imagenUser) {
        this.codigoEmpleado = codigoEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.apellidoEmpleado = apellidoEmpleado;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.cargo = cargo;
        this.salario = salario;
        this.oficina = oficina;
        this.estado = estado;
        this.codigoCargoEmpleado = codigoCargoEmpleado;
        this.imagenUser = imagenUser;
    }

    

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCodigoCargoEmpleado() {
        return codigoCargoEmpleado;
    }

    public void setCodigoCargoEmpleado(int codigoCargoEmpleado) {
        this.codigoCargoEmpleado = codigoCargoEmpleado;
    }

    public InputStream getImagenUser() {
        return imagenUser;
    }

    public void setImagenUser(InputStream imagenUser) {
        this.imagenUser = imagenUser;
    }
    
    
    

    
    
    

    
    
}
