package modelo;

public class CargoEmpleado {
    private int codigoCargoEmpleado;
    private String nombreCargo;
    private String descripcion;
    private double salarioBase;
    private int nivelJerarquico;
    private String estado;
    public CargoEmpleado() {
    }

    public CargoEmpleado(int codigoCargoEmpleado, String nombreCargo, String descripcion, double salarioBase, int nivelJerarquico, String estado) {
        this.codigoCargoEmpleado = codigoCargoEmpleado;
        this.nombreCargo = nombreCargo;
        this.descripcion = descripcion;
        this.salarioBase = salarioBase;
        this.nivelJerarquico = nivelJerarquico;
        this.estado = estado;
    }

    public int getCodigoCargoEmpleado() {
        return codigoCargoEmpleado;
    }

    public void setCodigoCargoEmpleado(int codigoCargoEmpleado) {
        this.codigoCargoEmpleado = codigoCargoEmpleado;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public int getNivelJerarquico() {
        return nivelJerarquico;
    }

    public void setNivelJerarquico(int nivelJerarquico) {
        this.nivelJerarquico = nivelJerarquico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
