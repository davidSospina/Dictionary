/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionaryserver_network;

import dictionaryserver_elements.Dictionary;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andres
 */
public class NetServer {
    
    private DatagramSocket socket = null;
    private int port;
    private InetAddress destinatarioIP;
    private int destinatarioPuerto; 
    
    private Dictionary dictionary;
    
    public NetServer(int port, Dictionary d){
        this.port = port;
        this.dictionary = d;
    }
    
    public void activate() throws SocketException{
        //Lanza excepcion porque el puerto puede estar ocupado
        socket = new DatagramSocket(port);
        
        process();
    }
    
    public void process() {
        while(true){
            
            byte[] mensajeRecibido = null;
            
            try {
                mensajeRecibido = reciveMessage();
                
                byte[] respuesta = this.dictionary.interpret(mensajeRecibido);
                if(respuesta == null)
                {
                    break;
                }
                
                sendMessage(respuesta, destinatarioIP, destinatarioPuerto);
            } catch (IOException ex) {
                Logger.getLogger(NetServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            this.sendMessage("Hasta la proxima".getBytes(), destinatarioIP, port);
        } catch (IOException ex) {
            Logger.getLogger(NetServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.deactivate();
    }
  
    public void deactivate(){
        socket.close();
    }
    
    public void sendMessage(byte[] mensaje, InetAddress destinatario, int puerto) 
            throws IOException{
        byte[] hoja = new String(mensaje).getBytes();
        
        DatagramPacket sobre = new DatagramPacket
            (hoja, hoja.length, destinatario, puerto);
        
        socket.send(sobre);
    }
    
    public byte[] reciveMessage() throws IOException{
        byte[] hoja = new byte[1000];
                
        DatagramPacket sobre = new DatagramPacket
            (hoja, hoja.length);
        
        //System.out.println("SERVIDOR recibió antes: " + new String(sobre.getData()));
        
        socket.receive(sobre);
        
        destinatarioIP = sobre.getAddress();
        destinatarioPuerto = sobre.getPort();
        
        //System.out.println("SERVIDOR recibió: " + new String(sobre.getData()));
        
        return sobre.getData();
    }

}
