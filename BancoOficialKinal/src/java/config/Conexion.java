package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
    Connection conexion;
    
    public Connection Conexion(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
//            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBBancoOficialKinal?useSSL=false", "root", "");
            //conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBBancoOficialKinal?useSSL=false", "Jose_Gonzalez", "rootPasword24");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBBancoOficialKinal?useSSL=false", "IN5AV", "admin");            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return conexion;
    }
          
}
