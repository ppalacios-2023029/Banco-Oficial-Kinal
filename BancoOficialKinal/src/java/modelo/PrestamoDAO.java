package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PrestamoDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public Prestamo validar(int codigoPrestamo , double monto){
        
        Prestamo prestamos = new Prestamo();
        String sql = "Select * from where codigoPrestamo = ? and monto = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigoPrestamo);
            ps.setDouble(2, monto);
            rs = ps.executeQuery();
            while(rs.next()){
                prestamos.setCodigoPrestamo(rs.getInt("codigoPrestamo"));
                prestamos.setMonto(rs.getDouble("monto"));
                prestamos.setTipoPrestamo(rs.getString("tipoPrestamo"));
                prestamos.setTasaInteres(rs.getDouble("tasaInteres"));
                prestamos.setEstado(rs.getString("estado"));
                prestamos.setCodigoCliente(rs.getInt("codigoCliente"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return prestamos;
    }
    
    // listar
    
    public List listar(){
        String sql = "Select * from Prestamos";
        List<Prestamo> listaPestamo = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Prestamo prestamo = new Prestamo();
                prestamo.setCodigoPrestamo(rs.getInt(1));
                prestamo.setMonto(rs.getDouble(2));
                prestamo.setTipoPrestamo(rs.getString(3));
                prestamo.setTasaInteres(rs.getDouble(4));
                prestamo.setFechaInicio(rs.getString(5));
                prestamo.setFechaVencimiento(rs.getString(6));
                prestamo.setEstado(rs.getString(7));
                prestamo.setCodigoCliente(rs.getInt(8));
                listaPestamo.add(prestamo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaPestamo;
    }
    
//    public boolean contieneLetras(String cadena) {
//        for (int i = 0; i < cadena.length(); i++) {
//            if (Character.isLetter(cadena.charAt(i))) {
//                return true;
//            }
//        }
//        return false;
//    }
//    
//    public int limpiarDecimales(String cadena) {
//        try {
//            // Convertir la cadena a un número decimal (double)
//            double numeroDecimal = Double.parseDouble(cadena);
//
//            // Usar Math.floor para redondear hacia abajo y convertir a int
//            return (int) Math.floor(numeroDecimal);
//        } catch (NumberFormatException e) {
//            // Manejo de error si la cadena no es un número válido
//            System.err.println("Error: La cadena '" + cadena + "' no es un número válido.");
//            return 0; // Valor predeterminado en caso de error
//        }
//    }
//    
//    public List barraBusqueda(String info) {
//        String sql = "Select * from Prestamos where monto like ? or tipoPrestamo like ? or tasaInteres like ? or fechaInicio like ? or fechaVencimiento like ? or estado like ? or codigoCliente like ?";
//        List<Empleado> listaEmpleado = new ArrayList<Empleado>();
//
//        try {
//            con = cn.Conexion();
//            ps = con.prepareStatement(sql);
//
//            ps.setString(1, info);
//            ps.setString(2, info);
//            ps.setString(3, info);
//            ps.setString(4, info);
//            ps.setString(5, info);
//            if (contieneLetras(info) == true) {
//                ps.setDouble(6, 0.0);
//            } else {
//                ps.setDouble(6, Double.parseDouble(info));
//            }
//            ps.setString(7, info);
//            ps.setString(8, info);
//            if (contieneLetras(info) == true) {
//                ps.setInt(9, 0);
//            } else {
//                int numFuncional = limpiarDecimales(info);
//                ps.setInt(9, numFuncional);
//            }
//
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                Empleado em = new Empleado();
//
//                em.setCodigoEmpleado(rs.getInt(1));
//                em.setNombreEmpleado(rs.getString(2));
//                em.setApellidoEmpleado(rs.getString(3));
//                em.setUsuario(rs.getString(4));
//                em.setContrasena(rs.getString(5));
//                em.setCargo(rs.getString(6));
//                em.setSalario(rs.getDouble(7));
//                em.setOficina(rs.getString(8));
//                em.setEstado(rs.getString(9));
//                em.setCodigoCargoEmpleado(rs.getInt(10));
//                listaEmpleado.add(em);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return listaEmpleado;
//    }
    
    // agregar 
    
    public int agregar(Prestamo pres){
        String sql = "INSERT INTO Prestamos (monto, tipoPrestamo, tasaInteres, fechaInicio, fechaVencimiento, estado, codigoCliente) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setDouble(1, pres.getMonto());
            ps.setString(2, pres.getTipoPrestamo());
            ps.setDouble(3, pres.getTasaInteres());
            ps.setString(4, pres.getFechaInicio());
            ps.setString(5, pres.getFechaVencimiento());
            ps.setString(6, pres.getEstado());
            ps.setInt(7, pres.getCodigoCliente());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    // buscar
    public Prestamo listarPrestamos(int id){
        Prestamo pres = new Prestamo();
        String sql = "Select * from Prestamos where codigoPrestamo = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                pres.setCodigoPrestamo(rs.getInt(1));
                pres.setMonto(rs.getDouble(2));
                pres.setTipoPrestamo(rs.getString(3));
                pres.setTasaInteres(rs.getDouble(4));
                pres.setFechaInicio(rs.getString(5));
                pres.setFechaVencimiento(rs.getString(6));
                pres.setEstado(rs.getString(7));
                pres.setCodigoCliente(rs.getInt(8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pres;
    }
    
    //editar
    
    public int actualizar(Prestamo pre){
        String sql = "Update Prestamos set monto = ? , tipoPrestamo = ?, tasaInteres = ?, fechaInicio = ?, fechaVencimiento = ?, estado = ? where codigoPrestamo = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setDouble(1, pre.getMonto());
            ps.setString(2, pre.getTipoPrestamo());
            ps.setDouble(3, pre.getTasaInteres());
            ps.setString(4, pre.getFechaInicio());
            ps.setString(5, pre.getFechaVencimiento());
            ps.setString(6, pre.getEstado());
            ps.setInt(8, pre.getCodigoPrestamo());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    //eliminar
    public void eliminar(int id){
        String sql = "Delete from Prestamos where codigoPrestamo =" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}