package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TransaccionDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public List listar(){
        String sql = "Select * from Transaccion";
        List<Transaccion> listaTransaccion = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Transaccion tr = new Transaccion();
                tr.setCodigoTransaccion(rs.getInt(1));
                tr.setEstadoTransaccion(rs.getString(2));
                tr.setTipoTransaccion(rs.getString(3));
                tr.setMonto(rs.getDouble(4));
                tr.setFecha(rs.getString(5));
                tr.setEstado(rs.getString(6));
                tr.setCodigoCliente(rs.getInt(7));
                listaTransaccion.add(tr);
            }            
        }catch (Exception e) {
            e.printStackTrace();
        }
        return listaTransaccion;
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

    public List barraBusqueda(String info){
        String sql = "Select * from Transaccion where estadoTransaccion like ? or TipoTransaccion like ? or Monto like ? or Fecha like ? or estado like ? or codigoCliente like ?";
        List<Transaccion> listaTransaccion = new ArrayList<Transaccion>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);        
            ps.setString(1, info);
            ps.setString(2, info);
            if (contieneLetras(info) == true) {
                ps.setDouble(3, 0.0);
            }else {
                ps.setDouble(3, Double.parseDouble(info));
            } 
            ps.setString(4, info);
            ps.setString(5, info);
            if (contieneLetras(info) == true) {
                ps.setInt(6, 0);
            } else {
                int numFuncional = limpiarDecimales(info);
                ps.setInt(6, numFuncional);
            }       
            
            rs = ps.executeQuery();
            while(rs.next()) {
                Transaccion tr = new Transaccion();
                tr.setCodigoTransaccion(rs.getInt(1));
                tr.setEstadoTransaccion(rs.getString(2));
                tr.setTipoTransaccion(rs.getString(3));
                tr.setMonto(rs.getDouble(4));
                tr.setFecha(rs.getString(5));
                tr.setEstado(rs.getString(6));
                tr.setCodigoCliente(rs.getInt(7));
                listaTransaccion.add(tr);                
            }            
        }catch (Exception e) {
            e.printStackTrace();
        }
        return listaTransaccion;   
    }
    
    public int agregar(Transaccion tra){
        String sql = "Insert into Transaccion (estadoTransaccion,TipoTransaccion,Monto,Fecha,estado,codigoCliente) values (?,?,?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);            
            ps.setString(1, tra.getEstadoTransaccion());
            ps.setString(2, tra.getTipoTransaccion());
            ps.setDouble(3, tra.getMonto());
            ps.setString(4, tra.getFecha());
            ps.setString(5, tra.getEstado());
            ps.setInt(6, tra.getCodigoCliente());
            ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    public Transaccion listarCodigoTransaccion(int id){
        Transaccion tra = new Transaccion();
        String sql = "Select * from Transaccion where codigoTransaccion ="+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                tra.setCodigoTransaccion(rs.getInt(1));
                tra.setEstadoTransaccion(rs.getString(2));
                tra.setTipoTransaccion(rs.getString(3));
                tra.setMonto(rs.getDouble(4));
                tra.setFecha(rs.getString(5));
                tra.setEstado(rs.getString(6));
                tra.setCodigoCliente(rs.getInt(7));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return tra;
    }
    
    public int actualizar(Transaccion tra){
        String sql = "Update Transaccion set estadoTransaccion = ?, TipoTransaccion = ?, Monto = ?, Fecha = ?, estado = ?, codigoCliente = ? where codigoTransaccion = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, tra.getEstadoTransaccion());
            ps.setString(2, tra.getTipoTransaccion());
            ps.setDouble(3, tra.getMonto());
            ps.setString(4, tra.getFecha());
            ps.setString(5, tra.getEstado());
            ps.setInt(6, tra.getCodigoCliente());  
            ps.setInt(7, tra.getCodigoTransaccion());
            ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    public void eliminar(int id) {
        String sql = "Delete from Transaccion where codigoTransaccion ="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
    
}
