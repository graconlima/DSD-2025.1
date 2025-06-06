package tcp.exemplo_2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

public class Cliente {

    static int porta = 1234;
    static String endereco = "localhost";//"10.25.2.30";

    public static void main(String[] args) {
        try{
            
            int vida = 3;
            
            while(true){
                Socket s = new Socket(endereco, porta);
                OutputStream os = s.getOutputStream();
                os.write(JOptionPane.showInputDialog("Informe um valor").getBytes());

                //Exemplo automatico
                //String str = new String("" + (int) (Math.random()*15) + 1);
                //os.write(str.getBytes());

                byte[] b = new byte[100];
                InputStream is = s.getInputStream();
                is.read(b);

                String m = new String(b).trim();
                System.out.println("Mensagem: "+m);
                
                if(m.equals("Voce acertou"))
                    return;
                
                vida--;
            }
        }catch(UnknownHostException uhe){
            uhe.printStackTrace();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
