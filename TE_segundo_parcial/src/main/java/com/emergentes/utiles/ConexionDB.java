
package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {
         private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/db_seminarios";
    private static final String user = "root";
    private static final String password = "";
    
    Connection conn = null;
    
    public ConexionDB(){
    try{
        
        Class.forName(driver);
        
        conn = DriverManager.getConnection(url, user, password);
        
        if (conn != null) {
            System.out.println("Conexion OK"+conn);
        }
        
        }catch(SQLException ex){
            System.out.print("Error al conectar"+ex.getMessage());
                }
    catch (ClassNotFoundException ex){
        Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE,null, ex);
        }  
    }
    public Connection conectar(){
    return conn;
    }
    
    public void desconectar(){
        try{

        
        conn.close();
        
        if (conn != null) {
            System.out.println("Conexion OK"+conn);
        }
        
        }catch(SQLException ex){
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE,null, ex);
                }
    }
}
