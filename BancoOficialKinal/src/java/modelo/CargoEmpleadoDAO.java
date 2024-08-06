/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andre Figueroa
 */
public class CargoEmpleadoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    public List listar() {
        String sql = "Select * from CargoEmpleado";
        List<CargoEmpleado> listaCargoEmpleado = new ArrayList<>();
        try {
            con= cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                CargoEmpleado cm = new CargoEmpleado();
                cm.setCodigoCargoEmpleado(rs.getInt(1));
                cm.setNombreCargo(rs.getString(2));
                cm.setDescripcion(rs.getString(3));
                cm.setSalarioBase(rs.getDouble(4));
                cm.setNivelJerarquico(rs.getInt(5));
                cm.setEstado(rs.getString(6));
                listaCargoEmpleado.add(cm); 
            }
        }catch(Exception e){
                e.printStackTrace();
        }
        return listaCargoEmpleado;
    } 
    
     public boolean contieneLetras(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            if (Character.isLetter(cadena.charAt(i))) {
                return true;
            }
        }
        return false;
    }
    
    public int limpiarDecimales(String cadena) {
        try {
            // Convertir la cadena a un número decimal (double)
            double numeroDecimal = Double.parseDouble(cadena);

            // Usar Math.floor para redondear hacia abajo y convertir a int
            return (int) Math.floor(numeroDecimal);
        } catch (NumberFormatException e) {
            // Manejo de error si la cadena no es un número válido
            System.err.println("Error: La cadena '" + cadena + "' no es un número válido.");
            return 0; // Valor predeterminado en caso de error
        }
    }
    
    public List barraBusqueda(String info) {
        String sql = "Select * from CargoEmpleado where nombreCargo like ? or descripcion like ? or salarioBase like ? or nivelJerarquico like ? or estado like ?";
        List<CargoEmpleado> listaCargoEmpleado = new ArrayList<CargoEmpleado>();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, info);
            ps.setString(2, info);
            if (contieneLetras(info) == true) {
                ps.setDouble(3, 0.0);
            } else {
                ps.setDouble(3, Double.parseDouble(info));
            }
            if (contieneLetras(info) == true) {
                ps.setInt(4, 0);
            } else {
                int numFuncional = limpiarDecimales(info);
                ps.setInt(4, numFuncional);
            }
            ps.setString(5, info);

            rs = ps.executeQuery();
            while (rs.next()) {
                CargoEmpleado cm = new CargoEmpleado();

                cm.setCodigoCargoEmpleado(rs.getInt(1));
                cm.setNombreCargo(rs.getString(2));
                cm.setDescripcion(rs.getString(3));
                cm.setSalarioBase(rs.getDouble(4));
                cm.setNivelJerarquico(rs.getInt(5));
                cm.setEstado(rs.getString(6));
                listaCargoEmpleado.add(cm);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaCargoEmpleado;
    }
    
    public int agregar(CargoEmpleado emp){
        String sql = "insert into CargoEmpleado (nombreCargo, descripcion, salarioBase, nivelJerarquico,estado) values (?,?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, emp.getNombreCargo());
            ps.setString(2, emp.getDescripcion());
            ps.setDouble(3, emp.getSalarioBase());
            ps.setInt(4, emp.getNivelJerarquico()); 
            ps.setString(5, emp.getEstado());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    public CargoEmpleado listarCodigoCargoEmpleado(int id){
        CargoEmpleado emp = new CargoEmpleado();
        String sql = "Select * from CargoEmpleado where CodigoCargoEmpleado = " + id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                emp.setCodigoCargoEmpleado(rs.getInt(1));
                emp.setNombreCargo(rs.getString(2));
                emp.setDescripcion(rs.getString(3));
                emp.setSalarioBase(rs.getDouble(4));
                emp.setNivelJerarquico(rs.getInt(5));
                emp.setEstado(rs.getString(6));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return emp;
    }
    
    public int actualizar(CargoEmpleado emp){
        String sql = "Update CargoEmpleado set nombreCargo = ?, descripcion = ?, salarioBase = ?, NivelJerarquico = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, emp.getNombreCargo());
            ps.setString(2, emp.getDescripcion());
            ps.setDouble(3, emp.getSalarioBase());
            ps.setInt(4, emp.getNivelJerarquico());
            ps.setString(5, emp.getEstado());
            ps.setInt(6, emp.getCodigoCargoEmpleado());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    public void eliminar(int id){
        String sql = "Delete from CargoEmpleado where codigoCargoEmpleado = "+ id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}