package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class SucursalesDAO {
  Conexion cn = new Conexion();
  Connection con;
  PreparedStatement ps;
  ResultSet rs;
  int resp;
  
  
    // METODO LISTAR
  public List listar (){
  String sql = "Select*from Sucursales";
  List<Sucursales> listaSucursales = new ArrayList<>();
  try{
      con = cn.Conexion();
      ps= con.prepareStatement(sql);
      rs = ps.executeQuery();
      while (rs.next()){
          Sucursales sc = new Sucursales();
          sc.setCodigoSucursal(rs.getInt(1));
          sc.setNombreSucursal(rs.getString(2));
          sc.setDireccionSucursal(rs.getString(3));
          sc.setTelefono(rs.getString(4));
          sc.setCorreoSucursal(rs.getString(5));
          sc.setEstado(rs.getString(6));
          sc.setCodigoEmpleado(rs.getInt(7));
          listaSucursales.add(sc);
      }
  }catch(Exception e){
      e.printStackTrace();
  }
  return listaSucursales;
  }
  
  
  // METODO AGREGAR 
  public int agregar (Sucursales scu){
      String sql = "insert into Sucursales (nombreSucursal,direccionSucursal,telefono,correoSucursal,codigoEmpleado) values(?,?,?,?,?)";
      try {
      con = cn.Conexion();
      ps = con.prepareStatement(sql);
      ps.setString(1, scu.getNombreSucursal());
      ps.setString(2, scu.getDireccionSucursal());
      ps.setString(3, scu.getTelefono());
      ps.setString(4, scu.getCorreoSucursal());
      ps.setString(5, scu.getEstado());
      ps.setInt(6, scu.getCodigoEmpleado());
      }catch(Exception e){
          e.printStackTrace();
      }
      return resp;
  }
  
  //BUSCAR POR CODIGO 
    public Sucursales listarCodigoSucursales (int id){
       Sucursales scu = new Sucursales ();
       String sql = "Select*from Sucursales where CodigoSucursales"+id;
       try{
       con = cn.Conexion();
       ps = con.prepareStatement(sql);
       rs = ps.executeQuery();
       while (rs.next()){
       scu.setNombreSucursal(rs.getString(2));
       scu.setDireccionSucursal(rs.getString(3));
       scu.setTelefono(rs.getString(4));
       scu.setCorreoSucursal(rs.getString(5));
       scu.setEstado(rs.getString(6));
       scu.setCodigoEmpleado(rs.getInt(7));
       }
       }catch(Exception e ){
           e.printStackTrace();
       }
       return scu;
    }
    
    // METODO EDITAR 
    public int actualizar (Sucursales scu){
        String sql = "update Sucursales set nombreSucusal = ?,"
                + " direccionSucursal = ?,"
                + " telefono = ?,"
                + " correoSucursal= ?,"
                + " where codigoScursal = ?";
            try {
             con = cn.Conexion();
             ps = con.prepareStatement(sql);
             ps.setString(1, scu.getNombreSucursal());
             ps.setString(2, scu.getDireccionSucursal());
             ps.setString(3, scu.getTelefono());
             ps.setString(4, scu.getCorreoSucursal());
             ps.setString(5, scu.getEstado());
            }catch (Exception e){
                e.printStackTrace();
            }
            return resp;
    }

        //METODO ELIMINAR 
    public void eliminar (int id ){
        String sql = "Delete form sucursales where codigoSucursal="+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    
    
    }
        
 
}
    
    
    
    

