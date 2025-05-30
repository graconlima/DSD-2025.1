package udp;

import java.net.DatagramSocket;
import java.net.DatagramPacket;

import java.net.SocketException;
import java.net.InetAddress;

import java.io.IOException;

public class Servidor {

    static int porta = 3000;
    private static byte[] mensagem = "Resposta...".getBytes();
    
    public static void main(String a[]){
        
        while(true){
            try{
               DatagramSocket soquete = new DatagramSocket(porta);

               byte buffer[] = new byte[65536];
               DatagramPacket dp = new DatagramPacket(buffer, buffer.length);

               System.out.println("Aguardando solicitacoes...");
               soquete.receive(dp);

               System.out.println(new String(dp.getData()).trim());
               System.out.println("ofst: "+dp.getOffset());
               System.out.println("lgt: "+dp.getLength());
               System.out.println("porta: "+dp.getPort());
               System.out.println("endereco: "+dp.getAddress());
               System.out.println("endereco socket: "+dp.getSocketAddress());

                System.out.println("\n\n");
                dp = new DatagramPacket(mensagem, mensagem.length, dp.getAddress(), dp.getPort());

                soquete.send(dp);
                soquete.close();
            }catch(SocketException se){
                se.printStackTrace();
            }catch(IOException ioe){
                ioe.printStackTrace();
            }    
        }
    }
}