package modelo;

import config.Conexion;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public class NuevaTarjetaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listar(){
        List<NuevaTarjeta> listaTarjetas = new ArrayList<>();
        String sql = "Select * from ProductoTarjeta";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                NuevaTarjeta nuevaTarjeta = new NuevaTarjeta();
                nuevaTarjeta.setCodigoNuevaTarjeta(rs.getInt(1));
                nuevaTarjeta.setTitulo(rs.getString(2));
                nuevaTarjeta.setImagen(rs.getBinaryStream(3));
                nuevaTarjeta.setDescripcion(rs.getString(4));
                nuevaTarjeta.setMonto(rs.getDouble(5));
                listaTarjetas.add(nuevaTarjeta);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaTarjetas;
    }
    
    public void listarImagen(int id, HttpServletResponse response){
        String sql = "Select * from ProductoTarjeta where codigoProductoTarjeta = "+id;
        InputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        OutputStream outPutStream = null;
        response.setContentType("image/*");
        try{
            outPutStream = response.getOutputStream();
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                inputStream = rs.getBinaryStream("imagen");
                
            }
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outPutStream);
            int i=0;
            while((i=bufferedInputStream.read())!=-1){
                bufferedOutputStream.write(i);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public void agregar(NuevaTarjeta nt){
        String sql = "insert into ProductoTarjeta (titulo,imagen,descripcion,cargoPorUso) values(?,?,?,?)";
        try{
            con = cn.Conexion();
            ps =con.prepareStatement(sql);
            ps.setString(1, nt.getTitulo());
            ps.setBlob(2, nt.getImagen());
            ps.setString(3, nt.getDescripcion());
            ps.setDouble(4, nt.getMonto());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
