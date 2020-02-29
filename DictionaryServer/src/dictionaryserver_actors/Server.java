/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionaryserver_actors;

import dictionaryserver_elements.Concept;
import dictionaryserver_elements.Dictionary;
import dictionaryserver_network.NetServer;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Carlos Andres Rojas
 * @author David Salgado Ospina
 */
public class Server {

    private NetServer net;
    private FriendServeManage manageFriend;

    public Server(int port, Dictionary d) {
        this.net = new NetServer(port, d);

    }

    public void activate() {
        try {
            this.net.activate();
        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deactivate() {
        this.net.deactivate();
    }

    public ArrayList<Concept> listarPalabrasFriends(ArrayList<FriendServer> friends) {
        ArrayList<Concept> lista = new ArrayList<>();
        for (FriendServer friend : friends) {
            String command = "LIST.HELP.SERVER";
            String response = "";

            try {
                this.manageFriend = new FriendServeManage(friend.getIp(), friend.getPort());
                response = this.manageFriend.process(command);
            } catch (SocketException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(response);
            String[] rs = response.split(";");
            if (rs.length > 1) {
                for (int i = 1; i < rs.length; i++) {
                    String con = rs[i];
                    if (con.split("-").length == 2) {
                        String word = con.split("-")[0];
                        String def = con.split("-")[1];
                        lista.add(new Concept(word, def));
                    }

                }
            }
        }
        return lista;
    }

    public Concept searchInFriends(ArrayList<FriendServer> friends, String word) {

        for (FriendServer friend : friends) {

            String command = "HELP.SERVER-" + word;
            String response = "";
            try {
                this.manageFriend = new FriendServeManage(friend.getIp(), friend.getPort());
                response = this.manageFriend.process(command);
            } catch (SocketException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }

//            System.out.println(response);
//            System.out.println("toyaqui");
            if (response.equalsIgnoreCase("500")) {
                System.out.println("Palabra no encontrada en el servidor: " + friend.getIp() + ": " + friend.getPort());
            } else {
                System.out.println("Palabra encontrada en el servidor: " + friend.getIp() + ": " + friend.getPort());
                if (response.split("-").length > 1) {
                    return new Concept(word, response.split("-")[2]);
                }
            }

        }
        return null;
        //this.manageFriend = new
        // return this.net.searchInFriends(fiends,word);
    }

//    public static void main(String[] args) {
//        Server server = new Server(4400);
//
//        server.activate();
//
//    }
    public static void main(String[] args) {

//        DataBase db = new DataBase() {};
//        //db.connect();
//        
//        //db.updateDefinition("Silla", "Objeto para sentarse");
//        db.insertConcept("BALON", "Objeto redondo para jugar");
//        db.selectAllConcepts();
//        System.out.println("/////");
//        //db.selectConcept("Silla");
//        db.deleteConcept("Silla");
        View v = new View();
        v.setVisible(true);
        Dictionary dictionary = new Dictionary(4400);

        //dictionary.activate();
    }
}
