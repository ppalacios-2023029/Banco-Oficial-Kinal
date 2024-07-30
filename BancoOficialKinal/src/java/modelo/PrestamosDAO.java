package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PrestamosDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public Prestamos validar(int codigoPrestamo , double monto){
        
        Prestamos prestamos = new Prestamos();
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
                prestamos.setCodigoCliente(rs.getInt("codigoPrestamo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return prestamos;
    }
    
    // listar
    
    public List listar(){
        String sql = "Select * from Prestamos";
        List<Prestamos> listaPestamo = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Prestamos prestamo = new Prestamos();
                prestamo.setCodigoPrestamo(rs.getInt(1));
                prestamo.setMonto(rs.getDouble(2));
                prestamo.setTipoPrestamo(rs.getString(3));
                prestamo.setTasaInteres(rs.getDouble(4));
                prestamo.setFechaInicio(rs.getDate(5));
                prestamo.setFechaVencimiento(rs.getDate(6));
                prestamo.setEstado(rs.getString(7));
                prestamo.setCodigoCliente(rs.getInt(8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaPestamo;
    }
    
    // agregar 
    
    public int agregar(Prestamos pres){
        String sql = "insert into Prestamos(codigoPrestamo, monto, tipoPrestamo, tasaInteres, fechaInicio, fechaVencimiento, estado, codigoCliente) values (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setDouble(1, pres.getMonto());
            ps.setString(2, pres.getTipoPrestamo());
            ps.setDouble(3, pres.getTasaInteres());
            ps.setDate(4, (java.sql.Date) pres.getFechaInicio());
            ps.setDate(5, (java.sql.Date) pres.getFechaVencimiento());
            ps.setString(6, pres.getEstado());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    // buscar
    public Prestamos listarPrestamos(int id){
        Prestamos pres = new Prestamos();
        String sql = "Select * from Prestamos where codigoPrestamo = " + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                pres.setMonto(rs.getDouble(2));
                pres.setTipoPrestamo(rs.getString(3));
                pres.setTasaInteres(rs.getDouble(4));
                pres.setFechaInicio(rs.getDate(5));
                pres.setFechaVencimiento(rs.getDate(6));
                pres.setEstado(rs.getString(7));
                pres.setCodigoCliente(rs.getInt(8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pres;
    }
    
    //editar
    
    public int actualizar(Prestamos pre){
        String sql = "Update Prestamos ser monto = ? , tipoPrestamo = ?, tasaInteres = ?, fechaInicio = ?, fechaVencimiento = ?, estado = ?";
        try {
            con = cn.Conexion();
            ps.setDouble(1, pre.getMonto());
            ps.setString(2, pre.getTipoPrestamo());
            ps.setDouble(3, pre.getTasaInteres());
            ps.setDate(4, (java.sql.Date) pre.getFechaInicio());
            ps.setDate(5, (java.sql.Date) pre.getFechaVencimiento());
            ps.setString(6, pre.getEstado());
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