package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculadoraRemota extends UnicastRemoteObject implements Calculadora{
        public CalculadoraRemota() throws RemoteException{
                super();
        }
        public int soma(int a, int b){
                return a+b;
        }
}
