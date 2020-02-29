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
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Carlos Andres Rojas
 * @author David Salgado Ospina
 */
public class Client {
    
    private NetClient netClient;
    
    public Client(String ip,int port) throws SocketException, UnknownHostException {
        
        InetAddress servidor = InetAddress.getByName(ip);
        
        netClient = new NetClient(servidor, port);
    }
    
    public String process(String comando) {
        //Scanner teclado = new Scanner(System.in);
        
        while(true) {
            System.out.print(">> "+comando);
            
            String mensaje = comando;
            System.out.println(mensaje);
            if(mensaje.equalsIgnoreCase("BYE"))
                break;
            
            try {
                
                byte[] respuesta = netClient.work(mensaje.getBytes());
                System.out.println(new String(respuesta));
                return new String(respuesta);
                //System.out.print("<< " + new String(respuesta));
                
            } catch (IOException ex) {
                System.out.println("<< No se pudo enviar el mensaje: " + ex.getMessage());
            }
            System.out.println("");
            System.out.println(mensaje);
        }
        
        netClient.deactivate();
        return null;
    }
    
    public String searchConsept(String word)
    {
        String command = "SEARCH-"+word;
        String[] response = this.process(command).split("-");
        System.out.println(response[0]);
        if(response[0].equals("200")){
            return response[1]+":"+response[2];
        }else
            return "ERROR";
        
    }
    
    public boolean insertConsept(String word, String definition){
        String comando = "ADD-"+word+"-"+definition;
        String response = this.process(comando);
        return response.equals("200");
    }
    
    public boolean updateDefinition(String name, String definition){
        
        String command = "UPDATE-"+name+"-"+definition;
        System.out.println(command);
        String response = this.process(command);
        System.out.println(response);
        return response.equals("200");
    }
    
    public String selectAllConcepts(){
        
        String command = "LIST";
        String result = this.process(command);
        System.out.println(result);
        String[] response = result.split(";");
        if(response[0].equals("200")){
            return result;
        }else
            return "ERROR";
        
    }
    
    public boolean deleteConcept(String name) {
        String command = "DELETE-"+name;
        String result = this.process(command);
        
        return result.equals("200");
    }
    ////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////
    
//    public static void main(String[] args) throws UnknownHostException {
//        Client cliente;
//        try {
//            cliente = new Client("127.0.0.1", 4400);
//            //System.out.println(cliente.selectAllConcepts());
//            //cliente.process();
//        } catch (SocketException ex) {
//            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (UnknownHostException ex) {
//            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
    
}
