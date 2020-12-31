package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MatrixService extends Remote {

    int[][] getBlockC11(int[][] m1, int[][] m2) throws RemoteException;

    int[][] getBlockC12(int[][] m1, int[][] m2) throws RemoteException;

    int[][] getBlockC21(int[][] m1, int[][] m2) throws RemoteException;

    int[][] getBlockC22(int[][] m1, int[][] m2) throws RemoteException;

}