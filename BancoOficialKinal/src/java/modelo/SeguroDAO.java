package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SeguroDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp; 
    
    public Seguro validar(int numeroSeguro, int codigoCliente ){
        Seguro seguro = new Seguro();
        String sql = "select * from Seguro where numeroSeguro = ? and codigoCliente = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt (1, numeroSeguro);
            ps.setInt(2, codigoCliente);
            rs = ps.executeQuery();
            while(rs.next()){
                seguro.setNumeroSeguro(rs.getInt("numeroSeguro"));
                seguro.setNumeroPoliza(rs.getString("numeroPoliza"));
                seguro.setTipoSeguro(rs.getString("tipoSeguro"));
                seguro.setMontoAsegurado(rs.getDouble("montoAsegurado"));
                seguro.setPrimaMensual(rs.getDouble("primaMensual"));
                seguro.setFechaExpiracion(rs.getDate("fechaExpiracion"));
                seguro.setEstado(rs.getString("estado"));
                seguro.setCodigoCliente(rs.getInt("codigoCliente"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return seguro;
    }
    
    public List listar(){
        String sql = "select * from Seguro";
        List <Seguro> listaSeguro = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Seguro sg = new Seguro();
                sg.setNumeroSeguro(rs.getInt(1));
                sg.setNumeroPoliza(rs.getString(2));
                sg.setTipoSeguro(rs.getString(3));
                sg.setMontoAsegurado(rs.getDouble(4));
                sg.setPrimaMensual(rs.getDouble(5));
                sg.setFechaExpiracion(rs.getDate(6));
                sg.setEstado(rs.getString(7));
                sg.setCodigoCliente(rs.getInt(8));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaSeguro;
    }
    
    public int agregar(Seguro sg){
        String sql = "insert into Seguro (numeroSeguro, numeroPoliza, tipoSeguro, montoAsegurado, primaMensual, fechaExpiracion, estado) values (?, ?, ?, ?, ?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, sg.getNumeroSeguro());
            ps.setString(2, sg.getNumeroPoliza());
            ps.setString(3, sg.getTipoSeguro());
            ps.setDouble(4, sg.getMontoAsegurado());
            ps.setDouble(5, sg.getPrimaMensual());
            ps.setDate(6, (Date)sg.getFechaExpiracion());
            ps.setString(7, sg.getEstado());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    public Seguro listarNumeroSeguro(int id){
        Seguro sg = new Seguro();
        String sql = "Select * from Seguro where numeroSeguro = "+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                sg.setNumeroSeguro(rs.getInt(1));
                sg.setNumeroPoliza(rs.getString(2));
                sg.setTipoSeguro(rs.getString(3));
                sg.setMontoAsegurado(rs.getDouble(4));
                sg.setPrimaMensual(rs.getDouble(5));
                sg.setFechaExpiracion(rs.getDate(6));
                sg.setEstado(rs.getString(7));
                sg.setCodigoCliente(rs.getInt(8));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return sg;
    }
    
     public int actualizar(Seguro sg){
        String sql = "update Seguro set "
                + "numeroPoliza = ?, "
                + "tipoSeguro = ?,"
                + "montoAsegurado = ?,"
                + "primaMensual = ?, "
                + "fechaExpiracion = ?' "
                + "estado = ?' "
                + "where numeroSeguro = ?";
        try{
            con = cn.Conexion(); 
            ps = con.prepareStatement(sql); 
            ps.setInt(1, sg.getNumeroSeguro()); 
            ps.setString(2, sg.getNumeroPoliza()); 
            ps.setString(3, sg.getTipoSeguro()); 
            ps.setDouble(4, sg.getMontoAsegurado()); 
            ps.setDouble(5, sg.getPrimaMensual());
            ps.setDate(6, (Date)sg.getFechaExpiracion());
            ps.setString(7, sg.getEstado());
            ps.setInt(8, sg.getCodigoCliente());
            ps.executeUpdate(); 
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
     
     public void eliminar(int id){
        String sql = "Delete from Seguro where numeroSeguro = "+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
}
