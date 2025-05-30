package protocolo_requisicao_resposta;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
/**
 *
 * @author Gracon Lima
 */
public class Servidor extends DatagramSocket{
    
    private DatagramPacket dp;
    private byte[] resposta;

    public Servidor(int porta) throws SocketException, IOException {

        super(porta);
        
        while(true){
        
            
            byte[] requisicao = getRequest();            

            invocarOperacao(requisicao);

            sendReply(resposta, dp.getAddress(), dp.getPort());
        }
    }
    
    public byte[] getRequest() throws IOException{

        byte[] b = new byte[1000];
        dp = new DatagramPacket(b, b.length);
        receive(dp);
        
        System.out.println(new String(dp.getData()).trim());
        
        return b;
    }
    
    private void invocarOperacao(byte[] requisicao){

        System.out.println("Invocando operacao...");
        
        String s = new String(requisicao);
        String[] as = s.split(",");//as virgulas dividem a mensagem
 
        for(int i = 0; i < as.length;i++){

            String[] aas = as[i].split(":");//cada chave-valor eh separado por dois pontos
            if(aas[0].equals("operacao")){
            
                switch(aas[1]){
                
                    case "0":
                        resposta = "Invocado o GET".getBytes();
                        System.out.println("Invocado o GET");
                        break;
                    case "1":
                        resposta = "Invocado o POST".getBytes();
                        System.out.println("Invocado o POST");
                        break;
                    case "2":
                        resposta = "Invocado o PUT".getBytes();
                        System.out.println("Invocado o PUT");
                       break;
                    default:
                        resposta = "Nao encontrado...".getBytes();
                        System.out.println("Nao encontrado");
                }
            }
        }
    }
    
    public void sendReply(byte[] resposta, InetAddress host_cliente, int porta_cliente) throws IOException{
    
        dp = new DatagramPacket(resposta, resposta.length, host_cliente, porta_cliente);
        send(dp);
    }

    public static void main(String[] args) throws IOException {
        Servidor s = new Servidor(1234);
    }
}
