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
                seguro.setFechaExpiracion(rs.getString("fechaExpiracion"));
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
                sg.setFechaExpiracion(rs.getString(6));
                sg.setEstado(rs.getString(7));
                sg.setCodigoCliente(rs.getInt(8));
                listaSeguro.add(sg);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaSeguro;
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
            
            //Convertir la cadena a Fecha
            //date fechaExpiracion = Date(cadena);
            
        } catch (NumberFormatException e) {
            // Manejo de error si la cadena no es un número válido
            System.err.println("Error: La cadena '" + cadena + "' no es un número válido.");
            return 0; // Valor predeterminado en caso de error
        }
    }
    
    public List barraBusqueda(String info) {
        String sql = "Select * from Seguro where numeroPoliza like '' or tipoSeguro like '' or montoAsegurado like '' or primaMensual like '' or fechaExpiracion like '' or estado like '' or codigoCliente like 1";
        List<Seguro> listaSeguro = new ArrayList<Seguro>();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, info);
            ps.setString(2, info);
            if (contieneLetras(info) == true) {
                ps.setDouble(3, 0.0);
                ps.setDouble(4, 0.0);
            } else {
                ps.setDouble(3, Double.parseDouble(info));
                ps.setDouble(4, Double.parseDouble(info));
            }
            if (contieneLetras(info) == true) {
                 ps.setDate(5, java.sql.Date.valueOf("2000-01-01"));
            } else {
                int numFuncional = limpiarDecimales(info);
                ps.setDate(5, java.sql.Date.valueOf("2000-01-01"));
            }
            ps.setString(6, info);
            if (contieneLetras(info) == true) {
                ps.setInt(7, 0);
            } else {
                int numFuncional = limpiarDecimales(info);
                ps.setInt(7, numFuncional);
            }

            rs = ps.executeQuery();
            while (rs.next()) {
                Seguro sg = new Seguro();

                sg.setNumeroSeguro(rs.getInt(1));
                sg.setNumeroPoliza(rs.getString(2));
                sg.setTipoSeguro(rs.getString(3));
                sg.setMontoAsegurado(rs.getDouble(4));
                sg.setPrimaMensual(rs.getDouble(5));
                sg.setFechaExpiracion(rs.getString(6));
                sg.setEstado(rs.getString(7));
                sg.setCodigoCliente(rs.getInt(8));
                listaSeguro.add(sg);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaSeguro;
    }
    
    public int agregar(Seguro sg){
        String sql = "insert into Seguro (numeroPoliza, tipoSeguro, montoAsegurado, primaMensual, fechaExpiracion, estado, codigoCliente) values (?, ?, ?, ?, ?, ?, ?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, sg.getNumeroPoliza());
            ps.setString(2, sg.getTipoSeguro());
            ps.setDouble(3, sg.getMontoAsegurado());
            ps.setDouble(4, sg.getPrimaMensual());
            ps.setString(5, sg.getFechaExpiracion());
            ps.setString(6, sg.getEstado());
            ps.setInt(7, sg.getCodigoCliente());
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
                sg.setNumeroPoliza(rs.getString(1));
                sg.setTipoSeguro(rs.getString(2));
                sg.setMontoAsegurado(rs.getDouble(3));
                sg.setPrimaMensual(rs.getDouble(4));
                sg.setFechaExpiracion(rs.getString(5));
                sg.setEstado(rs.getString(6));
                sg.setNumeroSeguro(rs.getInt(7));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return sg;
    }
    
     public int actualizar(Seguro sg){
        String sql = "update Seguro set numeroPoliza = ?, tipoSeguro = ?, montoAsegurado = ?, primaMensual = ?, fechaExpiracion = ?, estado = ? where numeroSeguro = ?";
        try{
            con = cn.Conexion(); 
            ps = con.prepareStatement(sql);
            ps.setString(1, sg.getNumeroPoliza()); 
            ps.setString(2, sg.getTipoSeguro()); 
            ps.setDouble(3, sg.getMontoAsegurado()); 
            ps.setDouble(4, sg.getPrimaMensual());
            ps.setString(5, sg.getFechaExpiracion());
            ps.setString(6, sg.getEstado());
            ps.setInt(7, sg.getNumeroSeguro()); 
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
