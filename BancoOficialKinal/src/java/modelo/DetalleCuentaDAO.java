package modelo;
 
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
 
public class DetalleCuentaDAO {
    Conexion cn = new Conexion ();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    public List listar(){
        String sql = "Select * from DetalleCuenta";
        List<DetalleCuenta> listaDetalleCuenta = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                DetalleCuenta dc = new DetalleCuenta();
                dc.setCodigoDetalleCuenta(rs.getInt(1));
                dc.setFechaDetalle(rs.getString(2));
                dc.setTipoOperacion(rs.getString(3));
                dc.setEstadoCuenta(rs.getString(4));
                dc.setCodigoCliente(rs.getInt(5));
                dc.setCodigoEmpleado(rs.getInt(6));
                dc.setCodigoSucursal(rs.getInt(7));
                listaDetalleCuenta.add(dc); 
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaDetalleCuenta;
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
        String sql = "Select * from DetalleCuenta where fechaDetalle like '' or tipoOperacion like '' or estadoCuenta like '' or codigoCliente like ? or codigoEmpleado like ? or codigoSucursal like ? ;";
        List<DetalleCuenta> listaDetalleCuenta = new ArrayList<DetalleCuenta>();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, info);
            ps.setString(2, info);
            ps.setString(3, info);
            if (contieneLetras(info) == true) {
                ps.setInt(4, 0);
                ps.setInt(5, 0);
                ps.setInt(6, 0);
            } else {
                int numFuncional = limpiarDecimales(info);
                ps.setInt(4, numFuncional);
                ps.setInt(5, numFuncional);
                ps.setInt(6, numFuncional);
            }

            rs = ps.executeQuery();
            while (rs.next()) {
                DetalleCuenta dc = new DetalleCuenta();

                dc.setCodigoDetalleCuenta(rs.getInt(1));
                dc.setFechaDetalle(rs.getString(2));
                dc.setTipoOperacion(rs.getString(3));
                dc.setEstadoCuenta(rs.getString(4));
                dc.setCodigoCliente(rs.getInt(5));
                dc.setCodigoEmpleado(rs.getInt(6));
                dc.setCodigoSucursal(rs.getInt(7));
                listaDetalleCuenta.add(dc);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaDetalleCuenta;
    }
    
    public int agregar(DetalleCuenta dc){ 
        String sql = "insert into DetalleCuenta (fechaDetalle, tipoOperacion, estadoCuenta, codigoCliente, codigoEmpleado, codigoSucursal) values (?,?,?,?,?,?)"; 
        try{ 
            con = cn.Conexion(); 
            ps = con.prepareStatement(sql); 
            ps.setString(1, dc.getFechaDetalle()); 
            ps.setString(2, dc.getTipoOperacion()); 
            ps.setString(3, dc.getEstadoCuenta()); 
            ps.setInt(4, dc.getCodigoCliente()); 
            ps.setInt(5, dc.getCodigoEmpleado()); 
            ps.setInt(6, dc.getCodigoSucursal());
            //Se usa por norma porque se va a actualizar una nueva tupla entonces executeUpdate(); 
            ps.executeUpdate(); 
        }catch(Exception e){ 
            e.printStackTrace(); 
        } 
        return resp; 
    }
    public DetalleCuenta listarCodigoDetalleCuenta(int id){ 
        //Instanciar un objeto de tipo Empleado 
        DetalleCuenta dc = new DetalleCuenta(); 
        String sql = "Select * from DetalleCuenta where codigoDetalleCuenta = "+id; 
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                dc.setFechaDetalle(rs.getString(2));
                dc.setTipoOperacion(rs.getString(3));
                dc.setEstadoCuenta(rs.getString(4));
                dc.setCodigoCliente(rs.getInt(5));
                dc.setCodigoEmpleado(rs.getInt(6));
                dc.setCodigoSucursal(rs.getInt(7));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return dc; 
    }
    public int actualizar(DetalleCuenta dc){
        String sql = "update DetalleCuenta set fechaDetalle = ?, tipoOperacion = ?, estadoCuenta = ? where codigoDetalleCuenta = ?";
        try{
            con = cn.Conexion(); 
            ps = con.prepareStatement(sql); 
            ps.setString(1, dc.getFechaDetalle()); 
            ps.setString(2, dc.getTipoOperacion()); 
            ps.setString(3, dc.getEstadoCuenta()); 
            ps.setInt(4, dc.getCodigoDetalleCuenta()); 
            ps.executeUpdate(); 
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    public void eliminar(int id){
        String sql = "Delete from DetalleCuenta where codigoDetalleCuenta =" + id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}