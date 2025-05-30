package protocolo_requisicao_resposta;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
/**
 *
 * @author Gracon Lima
 */
public class Cliente {

    private DatagramSocket ds;
    private Mensagem mensagem;
    private byte[] argumentos = "SOLICITACAO DO CLIENTE".getBytes();
    private int id_requisicao = 0;//Um doOperation no cliente gera um requestId para cada mensagem de requisição
    
    
    public Cliente() throws SocketException, UnknownHostException, IOException {

        ds = new DatagramSocket();
                                                            //define q operacao quer q o servidor execute
        byte[] b = doOperation(new ReferenciaRemota("localhost", 1234), 0, this.argumentos);
        System.out.println("Resposta do servidor: \n\t"+new String(b).trim());
        
        //doOperation(new ReferenciaRemota("localhost", 1234), 0, this.argumentos);//gerar um novo request_id


    }
    
    //no protocolo requisicao-resposta a interacao consiste no cliente invocar operacoes remotas
    //id_operacao pode ser como GET, POST, etc...
    private byte[] doOperation(ReferenciaRemota servidor, int id_operacao, byte[] argumentos) throws IOException{    
        
        enviar(servidor, id_operacao, argumentos);
        byte[] b = receber(); 
        return b;
    }

   public void enviar(ReferenciaRemota servidor,int id_operacao, byte[] argumentos) throws IOException{

        //Um doOperation no cliente gera um requestId para cada mensagem de requisição
        mensagem = new Mensagem(0, gerarIdRequisicao(), id_operacao, argumentos);
        ds.send(new DatagramPacket(mensagem.getMensagem(), mensagem.getMensagem().length, servidor.getEndereco(), servidor.getPorta()));    
    }

   private int gerarIdRequisicao(){
   
       return id_requisicao++;
   }

    //precisa incluir a verificacao do idRequisicao
    public byte[] receber() throws IOException{
        byte[] b = new byte[1000];

        DatagramPacket resposta = new DatagramPacket(b, b.length);
        ds.receive(resposta);
        
        return b;
    }
    
    public static void main(String[] args) throws UnknownHostException, IOException {
        Cliente c = new Cliente();
    }
}