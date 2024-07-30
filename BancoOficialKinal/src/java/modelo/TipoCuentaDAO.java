package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TipoCuentaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    //Métodos del crud
    //Método Listar
    public List listar(){
        String sql = "Select * from TipoCuenta";
        List<TipoCuenta> listaTipoCuenta = new ArrayList();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                TipoCuenta tc = new TipoCuenta();
                tc.setCodigoTipoCuenta(rs.getInt(1));
                tc.setTipoCuenta(rs.getString(2));
                tc.setSaldoMinimoRequerido(rs.getDouble(3));
                tc.setTazaDeInteres(rs.getDouble(4));
                tc.setTazaDeImpuestos(rs.getDouble(5));
                tc.setEstado(rs.getString(6));
                listaTipoCuenta.add(tc);
            }
        }catch(Exception e){
        e.printStackTrace();
        }
    
        return listaTipoCuenta;
    }
    
    // Método Agregar
    public int agregar(TipoCuenta tc){
        String sql = "insert into TipoCuenta (tipoCuenta, saldoMinimoRequerido, tazaDeInteres, tazaDeImpuestos, estado) values (?, ?, ?, ?, ?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, tc.getTipoCuenta());
            ps.setDouble(2, tc.getSaldoMinimoRequerido());
            ps.setDouble(3, tc.getTazaDeInteres());
            ps.setDouble(4, tc.getTazaDeImpuestos());
            ps.setString(5, tc.getEstado());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    // Método Buscar por Codigo
    public TipoCuenta listarCodigoTipoCuenta(int id){
        TipoCuenta tc = new TipoCuenta();
        String sql = "select * from TipoCuenta where codigoTipoCuenta = "+ id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                tc.setTipoCuenta(rs.getString(2));
                tc.setSaldoMinimoRequerido(rs.getDouble(3));
                tc.setTazaDeInteres(rs.getDouble(4));
                tc.setTazaDeImpuestos(rs.getDouble(5));
                tc.setEstado(rs.getString(6));
            }
        }catch(Exception e){
        e.printStackTrace();
        }
        return tc;
    }
    
    // Método Editar
    public int actualizar(TipoCuenta tc){
        String sql = "Update TipoCuenta set tipoCuenta = ?, saldoMinimoRequerido = ?, tazaDeInteres = ?, tazaDeImpuestos = ?, estado = ? where codigoTipoCuenta = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, tc.getTipoCuenta());
            ps.setDouble(2, tc.getSaldoMinimoRequerido());
            ps.setDouble(3, tc.getTazaDeInteres());
            ps.setDouble(4, tc.getTazaDeImpuestos());
            ps.setString(5, tc.getEstado());
            ps.setInt(6, tc.getCodigoTipoCuenta());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    // Método Eliminar
    public void eliminar (int id){
        String sql = "Delete from TipoCuenta where codigoTipoCuenta = "+ id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
