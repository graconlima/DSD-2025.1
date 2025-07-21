package exfila;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Consumidor {
    public static void main(String args[]){
        try{
            //System.setProperty("org.omg.CORBA.ORBInitialHost", "10.25.1.213");
            //System.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
            InitialContext ic = new InitialContext();
            
            QueueConnectionFactory qcf = (QueueConnectionFactory) ic.lookup("FabricaFilas");
            QueueConnection qc = qcf.createQueueConnection();
            qc.start();
            
            Queue q = (Queue) ic.lookup("minhaFila");
            QueueSession qs = qc.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            QueueReceiver consumidor = qs.createReceiver(q);
            
            consumidor.setMessageListener(new OuvinteFila());
            
            System.out.println("Aguardando novas mensagens...");
            System.out.println("Para sair digite: CTRL+C");
            
            while(true){
                Thread.sleep(1000);
            }
            
        }catch(JMSException je){
            je.printStackTrace();
        }catch(NamingException ne){
            ne.printStackTrace();
        }catch(InterruptedException ie){
            ie.printStackTrace();
        }
    }
}
