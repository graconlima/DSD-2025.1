package protocolo_requisicao_resposta;

import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 *
 * @author Gracon Lima
 */
public class ReferenciaRemota {

    private InetAddress endereco;
    private int porta;

    public ReferenciaRemota(String endereco, int porta) throws UnknownHostException {
        this.endereco = InetAddress.getByName(endereco);
        this.porta = porta;        
    }

    public void setEndereco(InetAddress endereco) {
        this.endereco = endereco;
    }

    public InetAddress getEndereco() {
        System.out.println("Endereco:"+endereco);
        return endereco;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public int getPorta() {
        System.out.println("Porta:"+porta);
        return porta;
    }    
}
