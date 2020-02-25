/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionaryserver_actors;

import dictionaryserver_elements.Dictionary;
import dictionaryserver_network.NetServer;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Carlos Andres Rojas
 * @author David Salgado Ospina
 */
public class Server {

    private NetServer net;

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
    
    public void deactivate (){
        this.net.deactivate();
    }

//    public static void main(String[] args) {
//        Server server = new Server(4400);
//
//        server.activate();
//
//    }

}
