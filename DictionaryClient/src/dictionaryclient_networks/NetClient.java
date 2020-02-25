/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionaryclient_networks;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author Carlos Andres Rojas
 * @author David Salgado Ospina
 */
public class NetClient {
    
    private DatagramSocket socket = null;
    private int puerto;
    private InetAddress destino;
    
    public NetClient(InetAddress destino, int puerto) 
            throws SocketException{
        this.destino = destino;
        this.puerto = puerto;
        
        socket = new DatagramSocket();
    }

    
    public void deactivate(){
        socket.close();
    }
    
    public byte[] work(byte[] message) throws IOException {
        sendMessage(message);
        return reciveMessage();
    }
    
    public void sendMessage(byte[] mensaje) 
            throws IOException
    {
        byte[] hoja = new String(mensaje).getBytes();
        
        DatagramPacket sobre = new DatagramPacket
            (hoja, hoja.length, destino, puerto);
        
        //System.out.println("CLIENTE envió: " + new String(sobre.getData()));
        
        socket.send(sobre);
    }
    
    public byte[] reciveMessage() throws IOException{
        byte[] hoja = new byte[1000];
                
        DatagramPacket sobre = new DatagramPacket(hoja, hoja.length);
        
        socket.receive(sobre);
        
        return sobre.getData();
    }
    
    
}
