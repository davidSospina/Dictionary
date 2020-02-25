/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionaryserver_elements;

import dictionaryserver_actors.FriendServer;
import dictionaryserver_actors.Server;
import dictionaryserver_db.Conection;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andres
 */
public class Dictionary {

    private Server server;
    private ArrayList<FriendServer> friends;

    private Connection connection;

    private Consept consepts;

    public Dictionary(int port) {

        this.server = new Server(port, this);
        this.friends = new ArrayList<>();
        this.connection = new Conection().connect();
        
        getFriends();
        
        System.out.println("Numero de amigos: "+this.friends.size());
        
        consepts = new Consept();
        activate();

    }
    
    public void activate(){
        System.out.println("SERVIDOR ACTIVADO");
        this.server.activate();
        
    }

    ////////////////////////////////////////////////////////////////////////////
    public void getFriends() {

        String sql = "SELECT ip, port FROM friendServer";

        try (
                Statement stmt = this.connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                try {
                    //                System.out.println(rs.getInt("id") +  "\t" +
//                                   rs.getString("name") + "\t" +
//                                   rs.getString("definition"));

                    FriendServer friend = new FriendServer(rs.getString("ip"), rs.getInt("port"));
                    friends.add(friend);
                } catch (UnknownHostException ex) {
                    Logger.getLogger(Dictionary.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar todo: " + e.getMessage());
        }

    }
    
    ///////////////////////////////////////////////////////////////////////////
    
    public Consept searchConsept(String word)
    {
        Consept c = this.consepts.selectConcept(word, this.connection);
        
        if (c != null)
        {
            return c;
        }else{
            // Buscar en los otros servidores
            return null;
        }
        
    }
    
    public boolean insertConsept(String word, String definition){
        return this.consepts.insertConcept(word, definition, this.connection);
    }
    
    public boolean updateDefinition(String name, String definition){
        
        return this.consepts.updateDefinition(name, definition, this.connection);
        
    }
    
    public ArrayList<Consept> selectAllConcepts(){
        
        return this.consepts.selectAllConcepts(this.connection);
    }
    
    public boolean deleteConcept(String name) {
        return this.consepts.deleteConcept(name, connection);
    }
    ////////////////////////////////////////////////////////////////////////////
    
    public byte[] interpret(byte[] m){
        
        String[] message = new String(m).trim().split("-");
        
        String response = "500";
        System.out.println(new String(m).trim());
        switch (message[0]){
            case "ADD":
                
                if(insertConsept(message[1], message[2])){
                    response = "200";
                }else
                {
                    response = "500";
                }
                
                break;
                
            case "DELETE":
                if(deleteConcept(message[1])){
                    response = "200";
                }else
                {
                    response = "500";
                }
                break;
                
            case "UPDATE":
                if(updateDefinition(message[1], message[2])){
                    response = "200";
                }else
                {
                    response = "500";
                }
                break;
                
            case "SEARCH":
                Consept c = searchConsept(message[1]);
                if(c!= null){
                    response = "200-"+c.getWord()+"-"+c.getDefinition();
                }
                break;
                
            case "HELP":
                /// esto llega de otro servidor
                break;
                
            case "BYE":
            
                try {
                    this.connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Dictionary.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                response = null;
                break;


        }
        
        if(response != null)
            return response.getBytes();
        else{
            return null;
        }
        
    }

}
