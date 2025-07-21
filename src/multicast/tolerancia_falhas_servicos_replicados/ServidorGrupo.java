package multicast.tolerancia_falhas_servicos_replicados;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorGrupo {

    private int porta = 1234;
    private MulticastSocket ms;
    private InetAddress ia;
    private DatagramPacket dp;
    private DatagramSocket ds;
    private byte[] b = new byte[1000];
    
    public ServidorGrupo() {
        System.out.println("Servidor iniciado!");

        try {
            ms = new MulticastSocket(porta);   
            ia = InetAddress.getByName("224.0.0.251");
            //ia = InetAddress.getByName("239.0.0.1");
            ms.joinGroup(ia);
            ms.setTimeToLive(30);
            
            while(true){
                receber();
                enviar();
            }
            
        } catch (SocketException ex) {

                ex.printStackTrace();
        } catch (UnknownHostException ex) {

                ex.printStackTrace();
        } catch (IOException ex) {

            ex.printStackTrace();
        }
    }

    public void receber() throws IOException{

        dp = new DatagramPacket(b, b.length);

        System.out.println("Aguardando informacoes...");
        ms.receive(dp);

        String dado = new String(dp.getData());
        System.out.println("Recebido: "+dado);
    }
    
    public void enviar(){
        try {
            ds = new DatagramSocket();
            InetAddress end = dp.getAddress();
            int p = dp.getPort();
            System.out.println("Enviando para: "+dp.getAddress().getHostAddress()+" : "+dp.getPort());

            dp = new DatagramPacket(operacaoComum(), operacaoComum().length, end, p);
            ds.send(dp);
            ds.close();
        } catch (IOException ex) {
            Logger.getLogger(ServidorGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    public byte[] operacaoComum(){
        return "MENSAGEM 1".getBytes();    
    }

    public void fecharConexao(){
        ms.close();    
    }
    
    public static void main(String args[]){
    
        ServidorGrupo s = new ServidorGrupo();
    }
}