/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionaryserver_actors;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author andres
 */
public class FriendServeManage {
    
    private DatagramSocket socket = null;
    private int puerto;
    private InetAddress destino;
    
    public FriendServeManage(InetAddress destino, int puerto) 
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
    
    public String process(String comando) {
        //Scanner teclado = new Scanner(System.in);
        
        while(true) {
            System.out.print(">> "+comando);
            
            String mensaje = comando;
            
            if(mensaje.equalsIgnoreCase("BYE"))
                break;
            
            try {
                
                byte[] respuesta = this.work(mensaje.getBytes());
                System.out.println(new String(respuesta));
                return new String(respuesta);
                //System.out.print("<< " + new String(respuesta));
                
            } catch (IOException ex) {
                System.out.println("<< No se pudo enviar el mensaje: " + ex.getMessage());
            }
            System.out.println("");
            System.out.println(mensaje);
        }
        
        this.deactivate();
        return null;
    }
    
}
