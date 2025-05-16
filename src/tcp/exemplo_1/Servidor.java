package tcp.exemplo_1;

import java.net.ServerSocket;
import java.net.Socket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;

import java.util.Date;

public class Servidor{
    
    int porta = 1234;
    Date d;
    
    public Servidor(){
        try{
            ServerSocket ss = new ServerSocket(porta);
            System.out.println("Aguardando...");

            while(true){
                d = new Date();
                Socket s = ss.accept();
                OutputStream os = s.getOutputStream();
                os.write(d.toString().getBytes());
                os.close();
                System.out.println(d.toString()); 
           }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
    public static void main(String args[]){
        Servidor s = new Servidor();
    }
}
