package rmi2;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
public class ServidorRMI implements OlaRMI{    
    public String oi() throws RemoteException{
        
        System.out.println("Ola acessado");
        
        return "Ola Mundosss!";
    }
    public static void main(String args[]){
        try{
            ServidorRMI objeto = new ServidorRMI();
            OlaRMI stub = (OlaRMI) UnicastRemoteObject.exportObject(objeto, 0);
            Registry r = LocateRegistry.createRegistry(2000);
            r.bind("ObjetoOla", stub);
            System.out.println("Servidor pronto!");
        }catch(Exception e){}
    }
}
