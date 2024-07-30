package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public Empleado validar (String usuario, String contrasena){
        Empleado empleado = new Empleado();
        String sql = "Select * from Empleados where usuario = ? and contrasena = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contrasena);
            rs = ps.executeQuery();
            while(rs.next()){
                empleado.setCodigoEmpleado(rs.getInt("codigoEmpleado"));
                empleado.setContrasena(rs.getString("contrasena"));
                empleado.setNombreEmpleado(rs.getString("nombreEmpleado"));
                empleado.setUsuario(rs.getString("usuario"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return empleado;
    }
    //Método de Listar
    public List listar(){
        String sql = "Select * from Empleados";
        List<Empleado> listaEmpleado = new ArrayList<Empleado>();
        try{
            con= cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Empleado em = new Empleado();
                em.setCodigoEmpleado(rs.getInt(1));
                em.setNombreEmpleado(rs.getString(2));
                em.setApellidoEmpleado(rs.getString(3));
                em.setUsuario(rs.getString(4));
                em.setContrasena(rs.getString(5));
                em.setCargo(rs.getString(6));
                em.setSalario(rs.getDouble(7));
                em.setOficina(rs.getString(8));
                em.setEstado(rs.getString(9));
                em.setCodigoCargoEmpleado(rs.getInt(10));
                listaEmpleado.add(em);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaEmpleado;
    }
    
    
    //Método de Agregar
    public int agregar(Empleado emp){
        String sql = "Insert into Empleados (nombreEmpleado, apellidoEmpleado, usuario, contrasena, cargo, salario, oficina, estado , codigoCargoEmpleado)"
                + "values(?,?,?,?,?,?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, emp.getNombreEmpleado());
            ps.setString(2, emp.getApellidoEmpleado());
            ps.setString(3, emp.getUsuario());
            ps.setString(4, emp.getContrasena());
            ps.setString(5, emp.getCargo());
            ps.setDouble(6, emp.getSalario());
            ps.setString(7, emp.getOficina());
            ps.setString(8, emp.getEstado());
            ps.setInt(9, emp.getCodigoCargoEmpleado());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return resp;
    }
    
    //Método de buscar
    public Empleado listarCodigoEmpleado(int id){
        Empleado emp = new Empleado();
        String sql = "Select * from Empleados where codigoEmpleado = "+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                emp.setNombreEmpleado(rs.getString(2));
                emp.setApellidoEmpleado(rs.getString(3));
                emp.setUsuario(rs.getString(4));
                emp.setContrasena(rs.getString(5));
                emp.setCargo(rs.getString(6));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return emp;
    }
    
    
    //Método de editar
    public int actualizar(Empleado emp){
        String sql = "Update Empleado set nombreEmpleado = ? , apellidoEmpleado = ? , usuario = ? , contrasena = ?, cargo = ?, salario = ? , oficina = ? , estado = ? , codigoCargoEmpleado = ?"
                + "where codigoEmpleado = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, emp.getNombreEmpleado());
            ps.setString(2, emp.getApellidoEmpleado());
            ps.setString(3, emp.getUsuario());
            ps.setString(4, emp.getContrasena());
            ps.setString(5, emp.getCargo());
            ps.setDouble(6, emp.getSalario());
            ps.setString(7, emp.getOficina());
            ps.setString(8, emp.getEstado());
            ps.setInt(9, emp.getCodigoCargoEmpleado());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    //Método de eliminar
    public void eliminar(int id){
        String sql = "Delete from Empleados where codigoEmpleado ="+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
