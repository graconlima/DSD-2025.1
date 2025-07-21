/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package broadcast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author graco
 */

public class ServidorBroadcast {

    InetAddress enderecoBroadcast;
    int porta = 3000;
    
    public ServidorBroadcast() throws SocketException, IOException {
        
        
        byte[] mensagem = "Ola Mundo!".getBytes();
        DatagramSocket s = new DatagramSocket();
        s.setBroadcast(true);//habilita o envio em larga escala

        enderecoBroadcast  = InetAddress.getByName("10.25.255.255");//o endereco broadcast
        //enderecoBroadcast  = InetAddress.getByName("192.168.56.255");//o endereco broadcast
        DatagramPacket dp = new DatagramPacket(mensagem, mensagem.length, enderecoBroadcast, porta);
        s.send(dp);
        System.out.println("Enviado para EB: "+enderecoBroadcast.getHostAddress());

        s.close();
    }
    
    public static void main(String args[]) throws UnknownHostException, SocketException, IOException{
    
        ServidorBroadcast sb = new ServidorBroadcast();
    }
}
