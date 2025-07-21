package pubsub;

import java.util.Properties;
import javax.jms.*;
import javax.naming.InitialContext;
public class Assinante {
    public static void main(String[] args) {
        try {            
            //System.setProperty("org.omg.CORBA.ORBInitialHost", "10.25.1.213");
            //System.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
            
            InitialContext ic = new InitialContext();
            
            TopicConnectionFactory f = (TopicConnectionFactory) ic.lookup("FabricaTopicos");
            TopicConnection c = f.createTopicConnection();
            c.start();
            
            Topic t = (Topic) ic.lookup("meuTopico");
            TopicSession s = c.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
            TopicSubscriber assinante = s.createSubscriber(t);
            
            OuvinteDeMensagens ouvinte = new OuvinteDeMensagens();
            assinante.setMessageListener(ouvinte);
            System.out.println("Assinante1 esperando por mensagens...");
            System.out.println("Para sair tecle CTRL+C...");
            while (true) {
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
