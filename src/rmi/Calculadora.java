package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculadora extends Remote{
        public int soma(int a, int b) throws RemoteException;
}
