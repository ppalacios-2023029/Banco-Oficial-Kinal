package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TarjetaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;    
    int resp;
    
    //Métodos del CRUD
    
    public List<Tarjeta> listar() {
        String sql = "SELECT * FROM Tarjetas";
        List<Tarjeta> listaTarjeta = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Tarjeta tr = new Tarjeta();
                tr.setNumeroTarjeta(rs.getString(1));
                tr.setTipoTarjeta(rs.getString(2));
                tr.setCVC(rs.getString(3));
                tr.setFechaVencimiento(rs.getDate(4));
                tr.setFechaEmision(rs.getDate(5));
                tr.setLimiteDeCredito(rs.getDouble(6));
                tr.setEstado(rs.getString(7));
                tr.setCodigoCliente(rs.getInt(8));
                listaTarjeta.add(tr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listaTarjeta;
    }
    
    public int agregar(Tarjeta trj) {
        String sql = "INSERT INTO Tarjetas (numeroTarjeta, tipoTarjeta, CVC, fechaVencimiento, fechaEmision, limiteDeCredito, estado, codigoCliente) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        int rowsInserted = 0;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, trj.getNumeroTarjeta());
            ps.setString(2, trj.getTipoTarjeta());
            ps.setString(3, trj.getCVC());
            ps.setDate(4, (Date) trj.getFechaVencimiento());
            ps.setDate(5, (Date) trj.getFechaEmision());
            ps.setDouble(6, trj.getLimiteDeCredito());
            ps.setString(7, trj.getEstado());
            ps.setInt(8, trj.getCodigoCliente());
            rowsInserted = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return rowsInserted;
    }
    
    public Tarjeta listarNumeroTarjeta(String id) {
        Tarjeta trj = new Tarjeta();
        String sql = "SELECT * FROM Tarjetas WHERE numeroTarjeta = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                trj.setNumeroTarjeta(rs.getString(1));
                trj.setTipoTarjeta(rs.getString(2));
                trj.setCVC(rs.getString(3));
                trj.setFechaVencimiento(rs.getDate(4));
                trj.setFechaEmision(rs.getDate(5));
                trj.setLimiteDeCredito(rs.getDouble(6));
                trj.setEstado(rs.getString(7));
                trj.setCodigoCliente(rs.getInt(8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return trj;
    }
    
    public int actualizar(Tarjeta trj) {
        String sql = "UPDATE Tarjetas SET tipoTarjeta = ?, CVC = ?, fechaVencimiento = ?, fechaEmision = ?, limiteDeCredito = ?, estado = ?, codigoCliente = ? WHERE numeroTarjeta = ?";
        int rowsUpdated = 0;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, trj.getTipoTarjeta());
            ps.setString(2, trj.getCVC());
            ps.setDate(3, (Date) trj.getFechaVencimiento());
            ps.setDate(4, (Date) trj.getFechaEmision());
            ps.setDouble(5, trj.getLimiteDeCredito());
            ps.setString(6, trj.getEstado());
            ps.setInt(7, trj.getCodigoCliente());
            ps.setString(8, trj.getNumeroTarjeta());
            rowsUpdated = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return rowsUpdated;
    }
    
    public List<Tarjeta> barraBusqueda(String info) {
        String sql = "SELECT * FROM Tarjetas WHERE numeroTarjeta LIKE ? OR tipoTarjeta LIKE ? OR CVC LIKE ? OR fechaVencimiento LIKE ? OR fechaEmision LIKE ? OR limiteDeCredito LIKE ? OR estado LIKE ? OR codigoCliente LIKE ?";
        List<Tarjeta> listaTarjeta = new ArrayList<>();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            String queryParam = "%" + info + "%";

            ps.setString(1, queryParam);
            ps.setString(2, queryParam);
            ps.setString(3, queryParam);
            ps.setString(4, queryParam);
            ps.setString(5, queryParam);
            ps.setString(6, queryParam);
            ps.setString(7, queryParam);
            ps.setString(8, queryParam);

            rs = ps.executeQuery();
            while (rs.next()) {
                Tarjeta tr = new Tarjeta();
                tr.setNumeroTarjeta(rs.getString(1));
                tr.setTipoTarjeta(rs.getString(2));
                tr.setCVC(rs.getString(3));
                tr.setFechaVencimiento(rs.getDate(4));
                tr.setFechaEmision(rs.getDate(5));
                tr.setLimiteDeCredito(rs.getDouble(6));
                tr.setEstado(rs.getString(7));
                tr.setCodigoCliente(rs.getInt(8));
                listaTarjeta.add(tr);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listaTarjeta;
    }
    
    public void eliminar(String id) {
        String sql = "DELETE FROM Tarjetas WHERE numeroTarjeta = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
