package udp;

import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.io.IOException;

public class Cliente {
    
    static byte[] mensagem = "SOLICITACAO DO CLIENTE 2".getBytes();
    static int porta = 3000;
    public static void main(String a[]){
    
        try{
            DatagramSocket soquete = new DatagramSocket();
            DatagramPacket dp = new DatagramPacket(mensagem, mensagem.length,InetAddress.getByName("10.25.1.243"), porta);

            System.out.println("Enviando...");
            soquete.send(dp);

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