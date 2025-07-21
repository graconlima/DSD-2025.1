package multicast.notificacao_eventos;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ServidorMulticast {

    private int portaServidor = 1234;
    private int portaGrupo = 12345;
    //private MulticastSocket ms;
    private InetAddress ia;
    private InetAddress enderecoGrupo;
    private DatagramPacket dp;
    private DatagramSocket ds;
    private byte[] b;
    private String status;
    
    public ServidorMulticast() {
        System.out.println("Servidor iniciado!");

        try {
            ds = new DatagramSocket(portaServidor);   
            ia = InetAddress.getByName("localhost");
            enderecoGrupo = InetAddress.getByName("224.0.0.251");
            //enderecoGrupo = InetAddress.getByName("239.0.0.1");
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
        
        b = new byte[1000];//ainda exibindo caracteres a mais
        dp = new DatagramPacket(b, b.length);

        System.out.println("Aguardando informacoes...");
        ds.receive(dp);

        status = new String(dp.getData());
        System.out.println("Recebido: "+status);
    }
    
    public void enviar(){
        try {
            System.out.println("Enviando para: "+enderecoGrupo.getHostAddress()+" : "+portaGrupo);
            dp = new DatagramPacket(getStatus(), getStatus().length, enderecoGrupo, portaGrupo);
            ds.send(dp);
        } catch (IOException ex) {
        }    
    }

    public void setStatus(String status) {
        this.status = status;
    }
        
    public byte[] getStatus(){
        return status.getBytes();    
    }

    public void fecharConexao(){
        ds.close();    
    }
    
    public static void main(String args[]){
    
        ServidorMulticast s = new ServidorMulticast();
    }
}