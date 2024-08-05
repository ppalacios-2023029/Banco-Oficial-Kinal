/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author neryd
 */
public class CargoEmpleadoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    public List listar() {
        String sql = "Select * from CargoEmpleado";
        List<CargoEmpleado> listaCargoEmpleado = new ArrayList<CargoEmpleado>();
        try {
            con= cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                CargoEmpleado cm = new CargoEmpleado();
                cm.setCodigoCargoEmpleado(rs.getInt(1));
                cm.setNombreCargo(rs.getString(2));
                cm.setDescripcion(rs.getString(3));
                cm.setSalarioBase(rs.getDouble(4));
                cm.setNivelJerarquico(rs.getInt(5));
                cm.setEstado(rs.getString(6));
                listaCargoEmpleado.add(cm);
            }
        }catch(Exception e){
                e.printStackTrace();
        }
        return listaCargoEmpleado;
    }
}