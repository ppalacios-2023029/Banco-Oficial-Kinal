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
        String sql = "Select * from TipoCuenta where TipoCuenta like ? or SaldoMinimoRequerido like ? or TasaDeInteres like ? or TazaDeImpuestos like ? or estado like ? or codigoCargoEmpleado like ?";
        List<TipoCuenta> listaTipoCuenta = new ArrayList<TipoCuenta>();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, info);
            if (contieneLetras(info) == true) {
                ps.setDouble(2, 0.0);
            } else {
                ps.setDouble(2, Double.parseDouble(info));
            }
            if (contieneLetras(info) == true) {
                ps.setDouble(3, 0.0);
            } else {
                ps.setDouble(3, Double.parseDouble(info));
            }
            if (contieneLetras(info) == true) {
                ps.setDouble(4, 0.0);
            } else {
                ps.setDouble(4, Double.parseDouble(info));
            }
            if (contieneLetras(info) == true) {
                ps.setInt(5, 0);
            } else {
                int numFuncional = limpiarDecimales(info);
                ps.setInt(5, numFuncional);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                TipoCuenta tc = new TipoCuenta();
                
                tc.setTipoCuenta(rs.getString(1));
                tc.setSaldoMinimoRequerido(rs.getDouble(2));
                tc.setTazaDeInteres(rs.getDouble(3));
                tc.setTazaDeImpuestos(rs.getDouble(4));
                tc.setEstado(rs.getString(5));
                tc.setCodigoTipoCuenta(rs.getInt(6));
                listaTipoCuenta.add(tc);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaTipoCuenta;
    }
    
    // Método Agregar
    public int agregar(TipoCuenta tc){
        String sql = "insert into TipoCuenta (TipoCuenta, SaldoMinimoRequerido, TasaDeInteres, TazaDeImpuestos, estado) values (?, ?, ?, ?, ?)";
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
        String sql = "Update TipoCuenta set TipoCuenta = ?, SaldoMinimoRequerido = ?, TasaDeInteres = ?, TazaDeImpuestos = ?, estado = ? where codigoTipoCuenta = ?";
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
