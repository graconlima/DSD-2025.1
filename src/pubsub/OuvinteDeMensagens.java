package pubsub;

import javax.jms.MessageListener;
import javax.jms.Message;
import javax.jms.TextMessage;
public class OuvinteDeMensagens implements MessageListener{
    public void onMessage(Message m){
        try{
            TextMessage tm = (TextMessage) m;
            System.out.println("Mensagem recebida: "+tm.getText());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
