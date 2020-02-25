/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionaryserver_elements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author andres
 */
public class Consept {
    
    private String word;
    private String definition;

    public Consept(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }
    
     public Consept() {

    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
    
    
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    
    public boolean updateDefinition(String name, String definition, Connection conn) {
        String sql = "UPDATE words SET definition = ? "
                + "WHERE name = ?";
        boolean band = false;
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // set the corresponding param
            pstmt.setString(2, name);
            pstmt.setString(1, definition);
            // update 
            pstmt.executeUpdate();
            band = true;
            System.out.println("Actualización exitosa: " + name + ": " + definition);
        } catch (SQLException e) {
            System.out.println("Fallo en actualización: " + e.getMessage());
        }
        return band;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    public boolean insertConcept(String name, String definition, Connection conn) {
        String sql = "INSERT INTO words(name,definition) VALUES(?,?)";
        boolean band = false;
        try (
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, definition);
            pstmt.executeUpdate();
            band = true;
            System.out.println("Inserción exitosa: " + name + ": " + definition);
        } catch (SQLException e) {
            System.out.println("Fallo en inserción: " + e.getMessage());
        }
        return band;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    public ArrayList<Consept> selectAllConcepts(Connection conn){
        String sql = "SELECT id, name, definition FROM words";
        ArrayList<Consept> consepts = new ArrayList<>();
        try (
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("name") + "\t" +
                                   rs.getString("definition"));
                
                Consept consept = new Consept(rs.getString("name"), rs.getString("definition"));
                consepts.add(consept);
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar todo: " + e.getMessage());
        }
        
        return consepts;
       
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    public Consept selectConcept(String definition, Connection conn){
               String sql = "SELECT id, name, definition "
                          + "FROM words WHERE name = ?";
        Consept c = null;
                
        try (
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
                
                c = new Consept();
                c.setDefinition(rs.getString("name"));
                c.setDefinition(rs.getString("definition"));
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar concepto: " + e.getMessage());
        }
        return c;
    }
    /////////////////////////////////////////////////////////////////////////////
    public boolean deleteConcept(String name, Connection conn) {
        String sql = "DELETE FROM words WHERE name = ?";
        boolean band = false;
        try (
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setString(1, name);
            // execute the delete statement
            pstmt.executeUpdate();
            System.out.println("Concepto eliminado de forma exitosa: " + name);
            band = true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar concepto: " + e.getMessage());
        }
        
        return band;
    }
    
    
    
    
}
