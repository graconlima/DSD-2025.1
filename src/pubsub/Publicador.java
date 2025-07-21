package pubsub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.InitialContext;


public class Publicador {
    
    public Publicador(){
        try{            
            //System.setProperty("org.omg.CORBA.ORBInitialHost", "10.25.1.213");
            //System.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
            
            InitialContext ic = new InitialContext();
            
            TopicConnectionFactory tcf = (TopicConnectionFactory) ic.lookup("FabricaTopicos");
            TopicConnection c = tcf.createTopicConnection();
            c.start();
            
            Topic t = (Topic) ic.lookup("meuTopico");
            TopicSession s = c.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
            TopicPublisher publicador = s.createPublisher(t);
            
            TextMessage m = s.createTextMessage();
            publicarMensagem(publicador, m);
            c.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void publicarMensagem(TopicPublisher publicador, TextMessage m){
        try{
            BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.println("Escreva sua mensagem - para finalizar tecle FIM:");
            while(true){
                String l = b.readLine();
                
                if(l.equals("FIM"))
                    break;
                
                m.setText(l);
                publicador.publish(m);
                System.out.println("Mensagem enviada");
            }            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]){
        new Publicador();
    }
}
