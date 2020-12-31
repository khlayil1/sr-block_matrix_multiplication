package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MatrixServiceFactory extends Remote {
    MatrixService newMatrixService() throws RemoteException;
}
