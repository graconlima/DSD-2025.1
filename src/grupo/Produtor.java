package grupo;

import org.jgroups.JChannel;
import org.jgroups.Message;
public class Produtor {
    public Produtor(){
        try {
            JChannel canal = new JChannel();
            canal.connect("MeuGrupo");
            while(true){
                Message m = new Message();
                m.setBuffer("MENSAGEM".getBytes());
                canal.send(m);
            }
        } catch (Exception ex) {
               ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Produtor();
    }
}
