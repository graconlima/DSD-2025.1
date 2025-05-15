package tcp.exemplo_2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Servidor {
    
    static int porta = 1234;
    static int valorSecreto = (int) (Math.random()*15)+1;
    
    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(porta);
            System.out.println("Aguardando conexões... ");
            while(true){
                Socket s = ss.accept();

                //recebimento dos dados
                InputStream is = s.getInputStream();            
                byte[] b = new byte[7];
                is.read(b);

                int informado = Integer.parseInt(new String(b).trim());
                System.out.println("Informado: "+informado);

                //envio dos dados
                OutputStream os = s.getOutputStream();
                if(informado == valorSecreto){
                    os.write("Voce acertou".getBytes());
                    System.out.println("Certo");
                    return;
                }else{
                    os.write("Tente novamente".getBytes());
                    System.out.println("Errado");
                }
                
                s.close();
            }            

        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
