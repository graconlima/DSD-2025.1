package tcp.exemplo_1;

import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;
import java.io.InputStream;
public class Cliente {
    private String endereco = "10.25.1.243";
    private int porta = 1234;
    public Cliente(){
        try{
            Socket s =  new Socket(endereco, porta);
            InputStream is = s.getInputStream();
            byte[] b = new byte[1000];
            is.read(b);
            is.close();
            System.out.println("Dados: "+new String(b).trim());
        }catch(UnknownHostException uhe){
            uhe.printStackTrace();
        }catch(IOException ioe){       
            ioe.printStackTrace();
        }
    }
    public static void main(String args[]){
        Cliente c = new Cliente();
    }
}