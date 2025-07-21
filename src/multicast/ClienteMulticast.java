package multicast;

import java.net.MulticastSocket;
import java.io.IOException;
import java.net.InetAddress;
import java.net.DatagramPacket;
public class ClienteMulticast {

    private int porta = 1234;
    
    public ClienteMulticast(){
    
        try{
            System.out.println("Cliente iniciado!");

            MulticastSocket ms = new MulticastSocket(porta);
            InetAddress ia = InetAddress.getByName("224.0.0.251");            
            ms.joinGroup(ia);
            
            while(true){
                byte[] b = new byte[1000];            
                DatagramPacket dp = new DatagramPacket(b, b.length);
                System.out.println("Aguardando informacoes...");
                ms.receive(dp);
                String dado = new String(dp.getData());
                System.out.println("Recebido: "+dado);
            }
        }catch(IOException ioe){
        
            ioe.printStackTrace();
        }
    }
    
    public static void main(String args[]){
    
        ClienteMulticast c = new ClienteMulticast();
    }
}