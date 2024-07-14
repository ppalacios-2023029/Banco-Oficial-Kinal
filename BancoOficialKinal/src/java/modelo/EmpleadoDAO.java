package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmpleadoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public Empleado validar(String usuario,String contrasena){
        
        Empleado empleado = new Empleado();
        String sql = "select * from Empleados where usuario = ? and contrasena = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contrasena);
            rs = ps.executeQuery();
            while(rs.next()){
                empleado.setCodigoEmpleado(rs.getInt("codigoEmpleado"));
                empleado.setContrasena(rs.getString("contrasena"));
                empleado.setNombreEmpleado(rs.getString("nombreEmpleado"));
                empleado.setUsuario(rs.getString("usuario"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return empleado;
    }
    
}
