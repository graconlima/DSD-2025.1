package multicast;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ServidorMulticast {

    private int porta = 1234;
    
    public ServidorMulticast() {
    
        try {
            DatagramSocket ds = new DatagramSocket();
            
            InetAddress ia = InetAddress.getByName("224.0.0.251");
            //InetAddress ia = InetAddress.getByName("239.0.0.1");
            
            byte[] m = "MENSAGEM 1".getBytes();
            
            DatagramPacket dp = new DatagramPacket(m, m.length, ia, porta);
            ds.send(dp);
            
            ds.close();
        } catch (SocketException ex) {

                ex.printStackTrace();
        } catch (UnknownHostException ex) {

                ex.printStackTrace();
        } catch (IOException ex) {

            ex.printStackTrace();
        }
    }
    
    public static void main(String args[]){
    
        ServidorMulticast s = new ServidorMulticast();
    }
}