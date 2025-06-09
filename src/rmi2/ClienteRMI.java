package rmi2;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class ClienteRMI {
    public static void main(String[] args){
        String endereco = "localhost";
        int porta = 2000;
        try{
            Registry r = LocateRegistry.getRegistry(endereco, porta);
            OlaRMI stub = (OlaRMI) r.lookup("ObjetoOla");
            String resposta = stub.oi();
            System.out.println("resposta: "+resposta);
        }catch(Exception e){}
    }
}
