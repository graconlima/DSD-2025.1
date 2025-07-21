package grupo;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
public class Consumidor extends ReceiverAdapter{
    JChannel canal;
    public Consumidor(){
        try {
            canal = new JChannel();
            canal.connect("MeuGrupo");
            canal.receiver(this);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void receive(Message m) {
        super.receive(m);
        System.out.println("M: "+(String) new String(m.getBuffer()).trim());
    }
    public static void main(String[] args) {
        new Consumidor();
        System.out.println("Aguardando...");
    }
}
