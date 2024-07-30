package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TarjetaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;    
    int resp;
    
    //Métodos del CRUD
    
    public List listar(){
        String sql = "Select * from Tarjetas";
        List <Tarjeta> listaTarjeta = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Tarjeta tr = new Tarjeta();
                tr.setNumeroTarjeta(rs.getString(1));
                tr.setTipoTarjeta(rs.getString(2));
                tr.setCVC(rs.getString(3));
                tr.setFechaVencimiento(rs.getDate(4));
                tr.setFechaEmision(rs.getDate(5));
                tr.setLimiteDeCredito(rs.getDouble(6));
                tr.setEstado(rs.getString(7));
                tr.setCodigoCliente(rs.getInt(8));
                listaTarjeta.add(tr);
            }
        }catch(Exception e){
            e.printStackTrace();
        }   
        return listaTarjeta;
    }
    
    public int agregar(Tarjeta trj){
        String sql = "insert into Tarjetas (numeroTarjeta, tipoTarjeta, CVC, fechaVencimiento, fechaEmision, limiteDeCredito, estado, codigoCliente) values (?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, trj.getNumeroTarjeta());
            ps.setString(2, trj.getTipoTarjeta());
            ps.setString(3, trj.getCVC());
            ps.setDate(4, (Date) trj.getFechaVencimiento());
            ps.setDate(5, (Date) trj.getFechaEmision());
            ps.setDouble(6, trj.getLimiteDeCredito());
            ps.setString(7, trj.getEstado());
            ps.setInt(8, trj.getCodigoCliente());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    public Tarjeta listarNumeroTarjeta(String id){
        Tarjeta trj = new Tarjeta();
        String sql = "Select * from Tarjetas where numeroTarjeta = "+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                trj.setNumeroTarjeta(rs.getString(1));
                trj.setTipoTarjeta(rs.getString(2));
                trj.setCVC(rs.getString(3));
                trj.setFechaVencimiento(rs.getDate(4));
                trj.setFechaEmision(rs.getDate(5));
                trj.setLimiteDeCredito(rs.getDouble(6));
                trj.setEstado(rs.getString(7));
                trj.setCodigoCliente(rs.getInt(8));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return trj;
    }
    
    public int actualizar (Tarjeta trj){
        String sql = "Update Tarjetas set tipoTarjeta = ?,"
                + "CVC = ?, "
                + "fechaVencimiento = ?, "
                + "fechaEmision = ?, "
                + "limiteDeCredito = ?, "
                + "estado = ?, "
                + "where numeroTarjeta = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, trj.getNumeroTarjeta());
            ps.setString(2, trj.getTipoTarjeta());
            ps.setString(3, trj.getCVC());
            ps.setDate(4, (Date) trj.getFechaVencimiento());
            ps.setDate(5, (Date) trj.getFechaEmision());
            ps.setDouble(6, trj.getLimiteDeCredito());
            ps.setString(7, trj.getEstado());
            ps.setInt(8, trj.getCodigoCliente());
            ps.executeUpdate();            
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    public void eliminar(String id){
        String sql = "Delete from Tarjetas where numeroTarjeta ="+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate(); 
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}