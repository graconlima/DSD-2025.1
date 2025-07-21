package multicast.tolerancia_falhas_servicos_replicados;

import java.net.MulticastSocket;
import java.io.IOException;
import java.net.InetAddress;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ClienteMulticast {

    private int porta = 1234;
    
    public ClienteMulticast(){
        System.out.println("Cliente iniciado!");

        try{
            
            DatagramSocket ds = new DatagramSocket();
            InetAddress ia = InetAddress.getByName("224.0.0.251");
            //InetAddress ia = InetAddress.getByName("239.0.0.1");
            
            System.out.println("Enviando...");

            byte[] b = "MENSAGEM 1".getBytes();            
            DatagramPacket dp = new DatagramPacket(b, b.length, ia, porta);
            ds.send(dp);
            
            dp = new DatagramPacket(b, b.length);
            System.out.println("Aguardando informacoes...");
            
            ds.receive(dp);
            
            String dado = new String(dp.getData());
            
            System.out.println("Recebido: "+dado);
            ds.close();
            
        }catch(IOException ioe){
        
            ioe.printStackTrace();
        }
    }
    
    public static void main(String args[]){
    
        ClienteMulticast c = new ClienteMulticast();
    }
}