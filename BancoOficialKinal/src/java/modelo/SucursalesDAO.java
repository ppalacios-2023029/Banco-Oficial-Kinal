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
        String sql = "Select * from Sucursales where nombreSucursal like '' or direccionSucursal like '' or telefono like '' or correoSucursal like ''  or  estado like '' or codigoEmpleado like ?";
        List<Sucursales> listaSucursal = new ArrayList<Sucursales>();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, info);
            ps.setString(2, info);
            ps.setString(3, info);
            ps.setString(4, info);
            ps.setString(5, info);
            if (contieneLetras(info) == true) {
                ps.setInt(6, 0);
            } else {
                int numFuncional = limpiarDecimales(info);
                ps.setInt(6, numFuncional);
            }

            rs = ps.executeQuery();
            while (rs.next()) {
                Sucursales sc = new Sucursales();

                sc.setCodigoSucursal(rs.getInt(1));
                sc.setNombreSucursal(rs.getString(2));
                sc.setDireccionSucursal(rs.getString(3));
                sc.setTelefono(rs.getString(4));
                sc.setCorreoSucursal(rs.getString(6));
                sc.setEstado(rs.getString(8));
                sc.setCodigoEmpleado(rs.getInt(10));
                listaSucursal.add(sc);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaSucursal;
    }

  
  
  // METODO AGREGAR 
  public int agregar (Sucursales scu){
      String sql = "insert into Sucursales (nombreSucursal,direccionSucursal,telefono,correoSucursal, estado, codigoEmpleado) values(?,?,?,?,?,?)";
      try {
      con = cn.Conexion();
      ps = con.prepareStatement(sql);
      ps.setString(1, scu.getNombreSucursal());
      ps.setString(2, scu.getDireccionSucursal());
      ps.setString(3, scu.getTelefono());
      ps.setString(4, scu.getCorreoSucursal());
      ps.setString(5, scu.getEstado());
      ps.setInt(6, scu.getCodigoEmpleado());
      ps.executeUpdate();
      }catch(Exception e){
          e.printStackTrace();
      }
      return resp;
  }
  
  //BUSCAR POR CODIGO 
    public Sucursales listarCodigoSucursales (int id){
       Sucursales scu = new Sucursales ();
       String sql = "Select * from Sucursales where codigoSucursal = "+id;
       try{
       con = cn.Conexion();
       ps = con.prepareStatement(sql);
       rs = ps.executeQuery();
       while (rs.next()){
       scu.setCodigoSucursal(rs.getInt(1));
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
        String sql = "update Sucursales set nombreSucursal = ?,  direccionSucursal = ?, telefono = ?, correoSucursal = ?, estado = ? where codigoSucursal = ?";
            try {
             con = cn.Conexion();
             ps = con.prepareStatement(sql);
             ps.setString(1, scu.getNombreSucursal());
             ps.setString(2, scu.getDireccionSucursal());
             ps.setString(3, scu.getTelefono());
             ps.setString(4, scu.getCorreoSucursal());
             ps.setString(5, scu.getEstado());
             ps.setInt(6, scu.getCodigoSucursal());
             ps.executeUpdate();
            }catch (Exception e){
                e.printStackTrace();
            }
            return resp;
    }

        //METODO ELIMINAR 
    public void eliminar (int id ){
        String sql = "Delete from Sucursales where codigoSucursal="+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    
    
    }
        
 
}
    
    
    
    

