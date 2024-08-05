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

    public Empleado validar(String usuario, String contrasena) {
        Empleado empleado = new Empleado();
        String sql = "Select * from Empleados where usuario = ? and contrasena = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contrasena);
            rs = ps.executeQuery();
            while (rs.next()) {
                empleado.setCodigoEmpleado(rs.getInt("codigoEmpleado"));
                empleado.setContrasena(rs.getString("contrasena"));
                empleado.setNombreEmpleado(rs.getString("nombreEmpleado"));
                empleado.setUsuario(rs.getString("usuario"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empleado;
    }

    //Método de Listar
    public List listar() {
        String sql = "Select * from Empleados";
        List<Empleado> listaEmpleado = new ArrayList<Empleado>();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado em = new Empleado();
                CargoEmpleadoDAO cargoEmpleadoDAO = new CargoEmpleadoDAO();
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaEmpleado;
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
        String sql = "Select * from Empleados where nombreEmpleado like ? or apellidoEmpleado like ? or usuario like ? or contrasena like ? or cargo like ? or salario like ? or oficina like ? or estado like ? or codigoCargoEmpleado like ?";
        List<Empleado> listaEmpleado = new ArrayList<Empleado>();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, info);
            ps.setString(2, info);
            ps.setString(3, info);
            ps.setString(4, info);
            ps.setString(5, info);
            if (contieneLetras(info) == true) {
                ps.setDouble(6, 0.0);
            } else {
                ps.setDouble(6, Double.parseDouble(info));
            }
            ps.setString(7, info);
            ps.setString(8, info);
            if (contieneLetras(info) == true) {
                ps.setInt(9, 0);
            } else {
                int numFuncional = limpiarDecimales(info);
                ps.setInt(9, numFuncional);
            }

            rs = ps.executeQuery();
            while (rs.next()) {
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

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaEmpleado;
    }

    

    //Método de Agregar
    public int agregar(Empleado emp) {
        String sql = "INSERT INTO Empleados (nombreEmpleado, apellidoEmpleado, usuario, contrasena, cargo, salario, oficina, estado, codigoCargoEmpleado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resp;
    }

    //Método de buscar
    public Empleado listarCodigoEmpleado(int id) {
        Empleado emp = new Empleado();
        String sql = "Select * from Empleados where codigoEmpleado = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                emp.setCodigoEmpleado(rs.getInt(1));
                emp.setNombreEmpleado(rs.getString(2));
                emp.setApellidoEmpleado(rs.getString(3));
                emp.setUsuario(rs.getString(4));
                emp.setContrasena(rs.getString(5));
                emp.setCargo(rs.getString(6));
                emp.setSalario(rs.getDouble(7));
                emp.setOficina(rs.getString(8));
                emp.setEstado(rs.getString(9));
                emp.setCodigoCargoEmpleado(rs.getInt(10));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emp;
    }

    //Método de editar
    public int actualizar(Empleado emp) {
        String sql = "Update Empleados set nombreEmpleado = ? , apellidoEmpleado = ? , usuario = ? , contrasena = ?, cargo = ?, salario = ? , oficina = ? , estado = ? , codigoCargoEmpleado = ? where codigoEmpleado = ?";
        try {
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
            ps.setInt(10, emp.getCodigoEmpleado());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    //Método de eliminar
    public void eliminar(int id) {
        String sql = "Delete from Empleados where codigoEmpleado =" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
