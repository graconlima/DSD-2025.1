package rmi2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface OlaRMI extends Remote{

    public String oi() throws RemoteException;
}
