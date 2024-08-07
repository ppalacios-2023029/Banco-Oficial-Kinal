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
        String sql = "Select * from Prestamos where codigoPrestamo like ? or monto like ? or tipoPrestamo like ? or tasaInteres like ? or fechaInicio like ? or fechaVencimiento like ? or estado like ? or codigoCliente like ?";
        List<Prestamo> listaPrestamos = new ArrayList<Prestamo>();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            
            if (contieneLetras(info) == true) {
                ps.setInt(1, 0);
            } else {
                int numFuncional = limpiarDecimales(info);
                ps.setInt(1, numFuncional);
            }
             
            if (contieneLetras(info) == true) {
                ps.setDouble(2, 0.0);
            } else {
                ps.setDouble(2, Double.parseDouble(info));
            }
            
            ps.setString(3, info);
            
            if (contieneLetras(info) == true) {
                ps.setInt(4, 0);
            } else {
                int numFuncional = limpiarDecimales(info);
                ps.setInt(4, numFuncional);
            }
            
            ps.setString(5, info);
            ps.setString(6, info);
            ps.setString(7, info);
            
            if (contieneLetras(info) == true) {
                ps.setInt(8, 0);
            } else {
                int numFuncional = limpiarDecimales(info);
                ps.setInt(8, numFuncional);
            }

            rs = ps.executeQuery();
            while (rs.next()) {
                Prestamo pr = new Prestamo();

                pr.setCodigoPrestamo(rs.getInt(1));
                pr.setMonto(rs.getDouble(2));
                pr.setTipoPrestamo(rs.getString(3));
                pr.setTasaInteres(rs.getDouble(4));
                pr.setFechaInicio(rs.getString(5));
                pr.setFechaVencimiento(rs.getString(6));
                pr.setEstado(rs.getString(7));
                pr.setCodigoCliente(rs.getInt(8));
                listaPrestamos.add(pr);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaPrestamos;
    }
    
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
            ps.setInt(7, pre.getCodigoPrestamo());
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