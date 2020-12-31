import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {


    public static void main(String[] args) {
        System.setProperty("java.security.policy", "D:\\hadilRMI-sr\\src\\policy_server");


        try {
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new RMISecurityManager());
            }
            System.setProperty("java.rmi.server.hostname", "localhost");
            Registry registry = LocateRegistry.createRegistry(1888);

            MatrixServiceFactoryImp matrixServiceFactoryImp = new MatrixServiceFactoryImp();
            registry.rebind("matrixProduct", matrixServiceFactoryImp);

            System.out.println("Server UP");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
