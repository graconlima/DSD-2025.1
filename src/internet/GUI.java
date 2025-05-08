package internet;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI extends JFrame{

    GUI(){
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JTextArea jta = new JTextArea();
        add(jta, BorderLayout.NORTH);
        GridLayout gl = new GridLayout(1, 2);
        JPanel jp = new JPanel(gl);
        JTextField jtf = new JTextField("http://");
        JButton jb = new JButton("Enviar");
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jta.setText(acessar(jtf.getText()));
                setVisible(true);
            }
        });
        jp.add(jtf, BorderLayout.EAST);
        jp.add(jb, BorderLayout.WEST);
        add(jp, BorderLayout.SOUTH);
        setVisible(true);

    }
    
    String acessar(String s){
        StringBuffer sb = new StringBuffer();

        try{
            //String s = "http://142.250.219.14/";//ou http://google.com <- protocolo necessario (MUE)
            URL url = new URL(s);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            huc.setRequestMethod("GET");
            huc.setReadTimeout(15000);
            huc.connect();
            
            InputStream is = huc.getInputStream();
            int caractere;
            while((caractere = is.read()) != -1){
                sb.append((char)caractere);
            }

        }catch(MalformedURLException mue){
            mue.printStackTrace();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        new GUI();
    }
}
