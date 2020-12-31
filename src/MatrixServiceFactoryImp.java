import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MatrixServiceFactoryImp extends UnicastRemoteObject implements MatrixServiceFactory {

    MatrixServiceFactoryImp() throws RemoteException {
    }

    @Override
    public MatrixService newMatrixService() throws RemoteException {
        return new MatrixServiceImp();
    }
}



