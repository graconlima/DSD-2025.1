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
            while(true){
                Socket s = new Socket(endereco, porta);
                OutputStream os = s.getOutputStream();
                os.write(JOptionPane.showInputDialog("Informe um valor").getBytes());

                byte[] b = new byte[100];
                InputStream is = s.getInputStream();
                is.read(b);

                String m = new String(b).trim();
                System.out.println("Mensagem: "+m);
                
                if(m.equals("Voce acertou"))
                    return;
            }
        }catch(UnknownHostException uhe){
            uhe.printStackTrace();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
