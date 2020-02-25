/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionaryclient_actors;

import dictionaryclient_networks.NetClient;
import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DSO
 */
public class Client {
    
    private NetClient netClient;
    
    public Client(String ip,int port) throws SocketException, UnknownHostException {
        
        InetAddress servidor = InetAddress.getByName(ip);
        
        netClient = new NetClient(servidor, port);
    }
    
    public void process() {
        Scanner teclado = new Scanner(System.in);
        
        while(true) {
            System.out.print(">> ");
            
            String mensaje = teclado.next();
            
            if(mensaje.equalsIgnoreCase("Chao"))
                break;
            
            try {
                
                byte[] respuesta = netClient.work(mensaje.getBytes());
                
                System.out.print("<< " + new String(respuesta));
                
            } catch (IOException ex) {
                System.out.println("<< No se pudo enviar el mensaje: " + ex.getMessage());
            }
            
            System.out.println(mensaje);
        }
        
        netClient.deactivate();
    }
    
    //////////////////////////////////
    
    public static void main(String[] args) throws UnknownHostException{
        Client cliente;
        try {
            cliente = new Client("127.0.0.1",4400);
            
            cliente.process();
        } catch (SocketException ex) 
        {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) 
        {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
