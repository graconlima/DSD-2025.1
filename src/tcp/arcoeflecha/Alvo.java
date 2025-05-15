package tcp.arcoeflecha;

import java.awt.Dimension;
import java.awt.Point;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFrame;
import sun.misc.IOUtils;

public class Alvo extends JFrame{
    
    Flecha tentativa;
    Tela t = new Tela();
    int porta = 2000;
    
    public Alvo(){
        add(t);
        setSize(new Dimension(200, 200));
        setLocation(new Point(200, 200));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        try{
            ServerSocket ss = new ServerSocket(porta);
            System.out.println("Servidor aguardando tentativas...");
            while(true){
                Socket s = ss.accept();
                InputStream is = s.getInputStream();
                byte[] b = new byte[100];
                is.read(b);
                tentativa = new Flecha(new String(b).trim());
                t.setTentativa(tentativa);
                s.close();
                update(getGraphics());
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        
    }
    
    public static void main(String[] args) {
        new Alvo();
    }
}
