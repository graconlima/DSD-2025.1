package broadcast;

import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.io.IOException;

public class Cliente {
    
    static byte[] mensagem = new byte[1000];
    static int porta = 3000;
    public static void main(String args[]){
    
        try{
            DatagramSocket soquete = new DatagramSocket(3000);//precisa definir a porta
            DatagramPacket dp = new DatagramPacket(mensagem, mensagem.length);

            System.out.println("Recebendo...");
            soquete.receive(dp);

            System.out.println(new String(dp.getData()).trim());
            System.out.println("ofst: "+dp.getOffset());
            System.out.println("lgt: "+dp.getLength());
            System.out.println("porta: "+dp.getPort());
            System.out.println("endereco: "+dp.getAddress());
            System.out.println("endereco socket: "+dp.getSocketAddress());

            soquete.close();
        }catch(SocketException se){
        
            se.printStackTrace();
        }catch(UnknownHostException uhe){
        
            uhe.printStackTrace();
        }catch(IOException ioe){
        
            ioe.printStackTrace();
        }
    }
}