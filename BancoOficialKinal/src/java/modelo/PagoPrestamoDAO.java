/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PagoPrestamoDAO {
     Conexion cn = new Conexion();
     Connection con;
     PreparedStatement ps;
     ResultSet rs;
     int resp;
     
        public List listar(){
            String sql = "Select * from pagoPrestamo";
            List<PagoPrestamo> listaPagoPrestamo = new ArrayList<>();
            try{
                con = cn.Conexion();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()){
                    PagoPrestamo pp = new PagoPrestamo();
                    pp.setCodigoPagos(rs.getInt(1));
                    pp.setMonto(rs.getDouble(2));
                    pp.setFechaInicio(rs.getDate(3));
                    pp.setFechaVencimiento(rs.getDate(4));
                    pp.setCodigoPrestamo(rs.getInt(5));
                    pp.setEstado(rs.getString(6));
                    listaPagoPrestamo.add(pp);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            return listaPagoPrestamo;
        }
        
        
        public int agregar(PagoPrestamo pp){
            String sql = "insert into PagosPrestamos (monto, fechaInicio, fechaVencimiento, estado, codigoPrestamo) values (?,?,?,?,?)";
            try{
                con = cn.Conexion();
                ps = con.prepareStatement(sql);
                ps.setDouble(1, pp.getMonto());
                ps.setDate(2, (Date) pp.getFechaInicio());
                ps.setDate(3, (Date)pp.getFechaVencimiento());
                ps.setString(4, pp.getEstado());
                ps.setInt(5, pp.getCodigoPrestamo());
                
                ps.executeUpdate();                
                
            }catch(Exception e){
                e.printStackTrace();
            }
            return resp;
        }
        
        public PagoPrestamo listarCodigoPagoPrestamo(int id){ 
        PagoPrestamo pp = new PagoPrestamo(); 
        String sql = "Select * from PagoPrestamo where codigoPagos = "+id; 
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                pp.setMonto(rs.getDouble(1));
                pp.setFechaInicio(rs.getDate(2));
                pp.setFechaVencimiento(rs.getDate(3));
                pp.setEstado(rs.getString(4));
                pp.setCodigoPrestamo(rs.getInt(5));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
         
        return pp; 
    }
        
       public int actualizar(PagoPrestamo pp){
        String sql = "update PagosPrestamos set "
                + "monto = ?, "
                + "fechaInicio = ?,"
                + "fechaVencimiento = ?,"
                + "estado = ?, "
                + "codigoPrestamo = ?' "
                + "where codigoPagos = ?";
        try{
            con = cn.Conexion(); 
            ps = con.prepareStatement(sql); 
            ps.setDouble(1, pp.getMonto()); 
            ps.setDate(2, (Date)pp.getFechaInicio()); 
            ps.setDate(3, (Date)pp.getFechaVencimiento()); 
            ps.setString(4, pp.getEstado()); 
            ps.setInt(5, pp.getCodigoPrestamo());
            ps.setInt(6, pp.getCodigoPagos());
            ps.executeUpdate(); 
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    } 
       
       public void eliminar(int id){
           String sql = "Delete from PagosPrestamos where codigoPagos =" + id;
           try{
               con = cn.Conexion();
               ps = con.prepareStatement(sql);
               ps.executeUpdate();
           }catch(Exception e){
               e.printStackTrace();
           }
       }
}
