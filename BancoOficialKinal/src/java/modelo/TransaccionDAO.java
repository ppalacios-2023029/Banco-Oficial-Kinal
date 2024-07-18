package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransaccionDAO {
    //Declarar variables globales para la funcionalidad general
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    // Declarar variable global para agregar y actualizar
    int resp;
    
    //MÉTODOS A USAR
    //MÉTODO PARA LISTAR
    public List<Transaccion> listar(){
        String sql = "SELECT * FROM Transaccion";
        List<Transaccion> listaTransacciones = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Transaccion transaccion = new Transaccion();
                transaccion.setCodigoTransaccion(rs.getInt(1));
                transaccion.setEstadoTransaccion(rs.getString(2));
                transaccion.setTipoTransaccion(rs.getString(3));
                transaccion.setMonto(rs.getDouble(4));
                transaccion.setFecha(rs.getDate(5));
                transaccion.setEstado(rs.getString(6));
                transaccion.setCodigoCliente(rs.getInt(7));
                listaTransacciones.add(transaccion);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaTransacciones;
    }
    
    //MÉTODO DE AGREGAR
    public int agregar(Transaccion transaccion){
        String sql = "INSERT INTO Transaccion (estadoTransaccion, tipoTransaccion, monto, fecha, codigoCliente) VALUES (?, ?, ?, ?, ?)";
            try{
                con = cn.Conexion();
                ps = con.prepareStatement(sql);
                ps.setString(1, transaccion.getEstadoTransaccion());
                ps.setString(2, transaccion.getTipoTransaccion());
                ps.setDouble(3, transaccion.getMonto());
                ps.setDate(4, (java.sql.Date) transaccion.getFecha());
                ps.setString(5, transaccion.getEstado());
                ps.setInt(6, transaccion.getCodigoCliente());
                ps.executeUpdate();
            }catch(Exception e){
                e.printStackTrace();
            }    
        return resp;
    }
    
    
    //MÉTODO PARA LISTAR POR CÓDIGO
    public Transaccion listarCodigoTransaccion(int id){
        Transaccion transaccion = new Transaccion();
        String sql = "SELECT * FROM Transaccion WHERE codigoTransaccion = " + id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                transaccion.setCodigoTransaccion(rs.getInt(1));
                transaccion.setEstadoTransaccion(rs.getString(2));
                transaccion.setTipoTransaccion(rs.getString(3));
                transaccion.setMonto(rs.getDouble(4));
                transaccion.setFecha(rs.getDate(5));
                transaccion.setEstado(rs.getString(6));
                transaccion.setCodigoCliente(rs.getInt(7));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return transaccion;
    }
    
    
    //MÉTODO PARA ACTUALIZAR
    public int actualizar(Transaccion transaccion){
        String sql = "UPDATE Transaccion SET estadoTransaccion = ?, tipoTransaccion = ?, monto = ?, fecha = ? WHERE codigoTransaccion = ?";
            try{
                con = cn.Conexion();
                ps = con.prepareStatement(sql);
                ps.setString(1, transaccion.getEstadoTransaccion());
                ps.setString(2, transaccion.getTipoTransaccion());
                ps.setDouble(3, transaccion.getMonto());
                ps.setDate(4, (java.sql.Date) transaccion.getFecha());
                ps.setString(5, transaccion.getEstado());
                ps.executeUpdate();
            }catch(Exception e){
                e.printStackTrace();
            }    
        return resp;
    }
    
    //MÉTODO PARA ELIMINAR
    public void eliminar(int id){
        String sql = "DELETE FROM Transaccion WHERE codigoTransaccion = " + id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
