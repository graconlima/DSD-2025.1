package soap;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class CalculadoraCliente {
    public static void main(String args[]){
        
        try{
            URL url = new URL("http://10.25.2.109:9876/calcsoap?wsdl");
            QName qname = new QName("http://soap/", "ServicoCalculadoraService");
            
            Service ws = Service.create(url, qname);
            InterfaceCalculadora calc = ws.getPort(InterfaceCalculadora.class);            
            
            float x = 14, y = 7;
            System.out.println("SOMA: " + calc.soma(x, y));
            System.out.println("SUBTRACAO: "+calc.subtracao(x, y));
            System.out.println("MULTIPLICACAO: "+calc.multiplicacao(x, y));
            System.out.println("DIVISAO: "+calc.divisao(x, y));
            
        }catch(MalformedURLException mue){
            mue.printStackTrace();
        }
    }
}
