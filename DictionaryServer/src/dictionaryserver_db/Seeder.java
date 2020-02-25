/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionaryserver_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Carlos Andres Rojas
 * @author David Salgado Ospina
 */
public class Seeder {
    
    private Conection con;

    public Seeder() {
        con = new Conection();
    }
    
    public void insertConcept(String name, String definition) {
        String sql = "INSERT INTO words(name,definition) VALUES(?,?)";
 
        try (Connection conn = con.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, definition);
            pstmt.executeUpdate();
            System.out.println("Inserción exitosa: " + name + ": " + definition);
        } catch (SQLException e) {
            System.out.println("Fallo en inserción: " + e.getMessage());
        }
    }
    
    public void executeSeeds(){
        this.insertConcept("ACEPCION" ,"Cada significado de una palabra según sus diferentes contextos.");
        this.insertConcept("ACUSTICA","Estudio de la propagación del sonido.");
        this.insertConcept("ADJETIVO","Palabra que indica una cualidad del nombre o sustantivo, núcleo de la oración.");
        this.insertConcept("ADVERBIO","Palabra asistente del verbo.");
        this.insertConcept("AGRADAR","Cualidad que consiste en hablar o escribir con gracia y buen gusto");
        this.insertConcept("AGRESIVIDAD","Brío, empuje y decisión para acometer un propósito afrontando las consecuencias.");
        this.insertConcept("AMBIGÜEDAD","Un estilo es ambiguo cuando presenta los asuntos de manera que puede entenderse de más de una manera.");
        this.insertConcept("ARTE","Técnica, manera, forma, procedimiento, regla, norma.");
        this.insertConcept("ASTRONÓMICO","Algo desmesuradamente grande.");
        this.insertConcept("BASE","Fundamento o apoyo principal de algo. || 2. Sección constante de una palabra, compuesta por una raíz y uno o más afijos, como cant en cantar. ");
        this.insertConcept("CENSURA","Razonamiento que procura mover la conciencia de una persona con el fin de producir un cambio sincero");
        this.insertConcept("CODIGO","Signo, seña o regla que permite entender un mensaje.");
        this.insertConcept("COMA","Signo escrito u ortográfico que divide las frases y miembros cortos de una oración");
        this.insertConcept("COMPETENCIA","Cuando no se la utiliza con cuidado, esta palabra pudiera confundir por sus diferencias de significado. Se requiere entendimiento para discernir a qué se refiere el texto.");
        this.insertConcept("CONGRESO","Reunión de personas o conferencia en que los miembros de una organización disciernen o debaten ordenadamente cuestiones importantes.");
    }
    
    
    public static void main(String[] args){
        Seeder seed = new Seeder();
        
        seed.executeSeeds();
    }
    
    
}
