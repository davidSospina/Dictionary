/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionaryserver_db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author andres
 */
public class Conection {
    
    private Connection conn;
    
    
    public Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:dictionary.db";
        conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Conexión DB exitosa");
        } catch (SQLException e) {
            System.out.println("Falla en conexión DB: " + e.getMessage());
        }
        return conn;
    }
     
    public void closeConnection(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo cerrar la conexion");
        }
    }
}
