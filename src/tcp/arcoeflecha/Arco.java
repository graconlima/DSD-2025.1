package tcp.arcoeflecha;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Arco {
    public Arco(){
        
        try{
        //10.25.2.30
        Socket s = new Socket("10.25.1.243", 2000);
        OutputStream os = s.getOutputStream();
        
        String str = "nome_aluno:100:50";
        os.write(str.getBytes());
        s.close();
        
        }catch(UnknownHostException uhe){
            uhe.printStackTrace();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new Arco();
    }
}
