package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    //Método de listar
    public List listar(){
    String sql = "select * from Clientes"; 
    List<Clientes> listaClientes = new ArrayList<>();
    try{
        con = cn.Conexion();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while(rs.next()){
            Clientes cl = new Clientes();
            cl.setCodigoCliente(rs.getInt(1));
            cl.setNombreCliente(rs.getString(2));
            cl.setApellidoCliente(rs.getString(3));
            cl.setDireccionCliente(rs.getString(4));
            cl.setTelefonoCliente(rs.getString(5));
            cl.setCorreoCliente(rs.getString(6));
            cl.setDescripcion(rs.getString(7));
            cl.setEstado(rs.getString(8));
            cl.setCodigoTipoCuenta(rs.getInt(9));
            listaClientes.add(cl);
        }
    }catch(Exception e){
        e.printStackTrace();
    }
    return listaClientes;
    }
    
    //Método de agregar
public int agregar(Clientes cl){
    String sql = "insert into Clientes (nombreCliente, apellidoCliente, direccionCliente, telefonoCliente, correoCliente, descripcion, estado, codigoTipoCuenta) values (?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getNombreCliente());
            ps.setString(2, cl.getApellidoCliente());
            ps.setString(3, cl.getDireccionCliente());
            ps.setString(4, cl.getTelefonoCliente());
            ps.setString(5, cl.getCorreoCliente());
            ps.setString(6, cl.getDescripcion());
            ps.setString(7, cl.getEstado());
            ps.setInt(8, cl.getCodigoTipoCuenta());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    return resp;
    }

    //Método listar con clausula where
    public Clientes listaCodigoClientes(int id){
        Clientes cl = new Clientes();
        String sql = "select * from Clientes where codigoCliente =" + id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                cl.setCodigoCliente(rs.getInt(1));
                cl.setNombreCliente(rs.getString(2));
                cl.setApellidoCliente(rs.getString(3));
                cl.setDireccionCliente(rs.getString(4));
                cl.setTelefonoCliente(rs.getString(5));
                cl.setCorreoCliente(rs.getString(6));
                cl.setDescripcion(rs.getString(7));
                cl.setEstado(rs.getString(8));
                cl.setCodigoTipoCuenta(rs.getInt(9));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return cl;
    }   

//Método de actualizar
    public int actualizar(Clientes cl){
        String sql = "update Clientes set nombreCliente = ?, apellidoCliente = ?, direccionCliente = ?, telefonoCliente = ?, correoCliente = ?, descripcion = ?, estado = ? where codigoCliente = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getNombreCliente());
            ps.setString(2, cl.getApellidoCliente());
            ps.setString(3, cl.getDireccionCliente());
            ps.setString(4, cl.getTelefonoCliente());
            ps.setString(5, cl.getCorreoCliente());
            ps.setString(6, cl.getDescripcion());
            ps.setString(7, cl.getEstado());
            ps.setInt(8, cl.getCodigoTipoCuenta());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }

    //Método de eliminar
    public void eliminar(int id){
        String sql = "delete from Clientes where codigoCliente = " + id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}