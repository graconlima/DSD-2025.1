package exfila;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class OuvinteFila implements MessageListener{
    public void onMessage(Message m){
        
        TextMessage tm = (TextMessage) m;
        
        try{
            System.out.println("Mensagem recebida: "+tm.getText());
        }catch(JMSException je){
            je.printStackTrace();
        }
    }
}
