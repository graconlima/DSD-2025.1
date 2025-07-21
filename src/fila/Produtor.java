package exfila;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

public class Produtor {
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
            QueueSender produtor = qs.createSender(q);
            
            TextMessage tm = qs.createTextMessage();
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Escreva sua mensagem - FIM para encerrar");            
            while(true){
                String s = br.readLine();
                
                if(s.equals("FIM"))
                    break;
                
                tm.setText(s);
                produtor.send(tm);
                System.out.println("Mensagem foi enviada com sucesso");
            }
            
            qc.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
