package serviceImp;

import service.MatrixService;
import service.MatrixServiceFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MatrixServiceFactoryImp extends UnicastRemoteObject implements MatrixServiceFactory {

    public MatrixServiceFactoryImp() throws RemoteException {
    }

    @Override
    public MatrixService newMatrixService() throws RemoteException {
        return new MatrixServiceImp();
    }
}



