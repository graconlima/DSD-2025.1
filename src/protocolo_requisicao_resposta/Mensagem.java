package protocolo_requisicao_resposta;
/**
 *
 * @author Gracon Lima
 */
public class Mensagem {

    private int tipo_mensagem;//0-requisicao, 1-resposta
    private int id_requisicao;
    private int id_operacao;
    private byte[] argumentos = "argumento1:valor1,argumento2:valor2".getBytes();

    public Mensagem(int tipo_mensagem, int id_requisicao, int id_operacao, byte[] argumentos) {
        this.tipo_mensagem = tipo_mensagem;
        this.id_requisicao = id_requisicao;
        this.id_operacao = id_operacao;
        this.argumentos = argumentos;
    }
    
    public byte[] getMensagem(){

        String s = new String("tipo:"+tipo_mensagem+",requisicao:"+id_requisicao+",operacao:"+id_operacao+",argumentos:"+argumentos+".");
        System.out.println("GetMensagem:"+s);
        return s.getBytes();
    }
}
