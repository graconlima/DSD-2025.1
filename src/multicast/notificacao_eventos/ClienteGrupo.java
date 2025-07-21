package multicast.notificacao_eventos;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.MulticastSocket;
import java.io.IOException;
import java.net.InetAddress;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class ClienteGrupo extends JFrame implements ItemListener, Runnable{

    private String ENDERECO_SERVIDOR = "localhost";
    private int portaServidor = 1234;
    private int portaGrupo = 12345;
    private DatagramPacket dp;
    private DatagramSocket ds;//comunicar diretamente com o servidor
    private MulticastSocket ms;//comunicar com grupo de clientes
    private InetAddress ia;
    private byte[] b;
    
    //GUI
    private JLabel statusRecebido;
    private JRadioButton invisivel, disponivel, ocupado;
    private ButtonGroup bg;
    
    //contadorclientes
    static int idContador = 0;
    private int idCliente = 0;
    
    public ClienteGrupo(){
    
        //gravando o ID
        idContador++;
        setIdCliente(idContador);
        
        //conexao
        try{
            ds = new DatagramSocket();
            ms = new MulticastSocket(portaGrupo);
            ia = InetAddress.getByName("224.0.0.251");            
            //ia = InetAddress.getByName("239.0.0.1");            
            ms.joinGroup(ia);
                        
        }catch(IOException ioe){
        
            ioe.printStackTrace();
        }
        
        //Thread para receber
        Thread t = new Thread(this);
        t.start();

        //GUI
        
        invisivel = new JRadioButton("Invisível", false);
        invisivel.addItemListener(this);
        disponivel = new JRadioButton("Disponível", false);
        disponivel.addItemListener(this);
        ocupado = new JRadioButton("Ocupado", false);
        ocupado.addItemListener(this);

        setLayout(new GridLayout(7, 1));
        add(new JLabel("STATUS"));
        add(invisivel);
        add(disponivel);
        add(ocupado);
    
        bg = new ButtonGroup();
        bg.add(ocupado);
        bg.add(disponivel);
        bg.add(invisivel);
        
        //statusrecebido
        statusRecebido = new JLabel("Status Recebido");
        add(statusRecebido);
        
        setSize(200, 200);
        setLocation(200, 200);
        setVisible(true);
    }

    public void receber(){

        try{
            b = new byte[1000];
            dp = new DatagramPacket(b, b.length);

            System.out.println("Recebendo informacoes...");
            ms.receive(dp);

            String dado = new String(dp.getData());
            System.out.println("Recebido: "+dado);
            
            statusRecebido.setText(dado);
            setVisible(true);
            
        }catch(Exception e){
        
            e.printStackTrace();
        }
    }
    
    public void enviar(String s){
        try {
            ds = new DatagramSocket();
            InetAddress end = InetAddress.getByName(ENDERECO_SERVIDOR);
            
            System.out.println("Enviando para: "+end.getHostAddress()+" : "+portaServidor);

            dp = new DatagramPacket(s.getBytes(), s.getBytes().length, end, portaServidor);
            ds.send(dp);
            ds.close();
        } catch (IOException ex) {
        }    
    }
    
    public void fecharConexao(){
        ds.close();    
    }

    
    @Override
    public void run() {

        while(true){
            receber();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {

                ex.printStackTrace();
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {

        if(invisivel.isSelected()){
            System.out.println("Click Status: Invisivel");
            enviar("Cliente "+idCliente+" Invisivel");
        }
        if(ocupado.isSelected()){
            System.out.println("Click Status: Ocupado");        
            enviar("Cliente "+idCliente+"Ocupado");
        }
        if(disponivel.isSelected()){
            System.out.println("Click Status: disponivel");        
            enviar("Cliente "+idCliente+"Disponivel");
        }
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public static void setIdContador() {
        ClienteGrupo.idContador+=1;
    }

    public static int getIdContador() {
        return ClienteGrupo.idContador;
    }

    public static void main(String args[]){
    
        ClienteGrupo c = new ClienteGrupo();
        ClienteGrupo c1 = new ClienteGrupo();
        ClienteGrupo c2 = new ClienteGrupo();
        ClienteGrupo c4 = new ClienteGrupo();

        System.out.println("Clientes iniciados!");
    }
}