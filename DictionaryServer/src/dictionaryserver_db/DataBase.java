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
 * @author DSO
 */
public class DataBase {
       
    private Connection conn;
    
     private Connection connect() {
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
     
    public void updateDefinition(String name, String definition) {
        String sql = "UPDATE words SET definition = ? "
                + "WHERE name = ?";
 
        try{
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // set the corresponding param
            pstmt.setString(2, name);
            pstmt.setString(1, definition);
            // update 
            pstmt.executeUpdate();
            
            System.out.println("Actualización exitosa: " + name + ": " + definition);
        } catch (SQLException e) {
            System.out.println("Fallo en actualización: " + e.getMessage());
        }
    }
    
    public void insertConcept(String name, String definition) {
        String sql = "INSERT INTO words(name,definition) VALUES(?,?)";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, definition);
            pstmt.executeUpdate();
            System.out.println("Inserción exitosa: " + name + ": " + definition);
        } catch (SQLException e) {
            System.out.println("Fallo en inserción: " + e.getMessage());
        }
    }
    
    public void selectAllConcepts(){
        String sql = "SELECT id, name, definition FROM words";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("name") + "\t" +
                                   rs.getString("definition"));
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar todo: " + e.getMessage());
        }
    }
    
    public void selectConcept(String definition){
               String sql = "SELECT id, name, definition "
                          + "FROM words WHERE name = ?";
        
        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){
            
            // set the value
            pstmt.setString(1,definition);
            //
            ResultSet rs  = pstmt.executeQuery();
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("name") + "\t" +
                                   rs.getString("definition"));
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar concepto: " + e.getMessage());
        }
    }
    
    public void deleteConcept(String name) {
        String sql = "DELETE FROM words WHERE name = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setString(1, name);
            // execute the delete statement
            pstmt.executeUpdate();
            System.out.println("Concepto eliminado de forma exitosa: " + name);
        } catch (SQLException e) {
            System.out.println("Error al eliminar concepto: " + e.getMessage());
        }
    }
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        DataBase db = new DataBase() {};
        //db.connect();
        
        db.updateDefinition("Silla", "Objeto para sentarse");
        //db.insertConcept("Balón", "Objeto redondo para jugar");
        db.selectAllConcepts();
        System.out.println("/////");
        db.selectConcept("Silla");
        db.deleteConcept("Balón");
    }
}
