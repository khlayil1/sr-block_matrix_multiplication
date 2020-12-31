import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MatrixServiceImp extends UnicastRemoteObject implements MatrixService {


    MatrixServiceImp() throws RemoteException {
    }

    private int[][] productOf(int[][] mat1, int[][] mat2) {

        int[][] product = new int[0][];


        product = new int[mat1.length][mat2[0].length];
        for (int i = 0; i < mat1.length; i++)
            for (int k = 0; k < mat1[0].length; k++) {
                product[i][k] = 0;
                for (int j = 0; j < mat1[0].length; j++)
                    product[i][k] += mat1[i][j] * mat2[j][k];
            }


        return product;


    }

    private int[][] additionOf(int[][] m1, int[][] m2) {
        int n = m1.length;
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = m1[i][j] + m2[i][j];
            }
        }
        return res;
    }


    private void divideMatrixIntoBlocks(int[][] P, int[][] C, int i, int j) {
        for (int i1 = 0, i2 = i; i1 < C.length; i1++, i2++)
            for (int j1 = 0, j2 = j; j1 < C.length; j1++, j2++)
                C[i1][j1] = P[i2][j2];
    }


    @Override
    public int[][] getBlockC11(int[][] m1, int[][] m2) throws RemoteException {
        int n = m1.length;


        // first matrix
        int[][] a = new int[n / 2][n / 2];
        int[][] b = new int[n / 2][n / 2];
        int[][] c = new int[n / 2][n / 2];
        int[][] d = new int[n / 2][n / 2];

        // second matrix
        int[][] e = new int[n / 2][n / 2];
        int[][] f = new int[n / 2][n / 2];
        int[][] g = new int[n / 2][n / 2];
        int[][] h = new int[n / 2][n / 2];

        // dividing matrix A into 4 parts
        divideMatrixIntoBlocks(m1, a, 0, 0);
        divideMatrixIntoBlocks(m1, b, 0, n / 2);
        divideMatrixIntoBlocks(m1, c, n / 2, 0);
        divideMatrixIntoBlocks(m1, d, n / 2, n / 2);


        // dividing matrix B into 4 parts
        divideMatrixIntoBlocks(m2, e, 0, 0);
        divideMatrixIntoBlocks(m2, f, 0, n / 2);
        divideMatrixIntoBlocks(m2, g, n / 2, 0);
        divideMatrixIntoBlocks(m2, h, n / 2, n / 2);


        // C11 =a*e + b*g


        return additionOf(productOf(a, e), productOf(b, g));

    }


    @Override
    public int[][] getBlockC12(int[][] m1, int[][] m2) throws RemoteException {
        int n = m1.length;


        // first matrix
        int[][] a = new int[n / 2][n / 2];
        int[][] b = new int[n / 2][n / 2];
        int[][] c = new int[n / 2][n / 2];
        int[][] d = new int[n / 2][n / 2];

        // second matrix
        int[][] e = new int[n / 2][n / 2];
        int[][] f = new int[n / 2][n / 2];
        int[][] g = new int[n / 2][n / 2];
        int[][] h = new int[n / 2][n / 2];

        // dividing matrix A into 4 parts
        divideMatrixIntoBlocks(m1, a, 0, 0);
        divideMatrixIntoBlocks(m1, b, 0, n / 2);
        divideMatrixIntoBlocks(m1, c, n / 2, 0);
        divideMatrixIntoBlocks(m1, d, n / 2, n / 2);


        // dividing matrix B into 4 parts
        divideMatrixIntoBlocks(m2, e, 0, 0);
        divideMatrixIntoBlocks(m2, f, 0, n / 2);
        divideMatrixIntoBlocks(m2, g, n / 2, 0);
        divideMatrixIntoBlocks(m2, h, n / 2, n / 2);


        // C11 =a*f + b*h


        return additionOf(productOf(a, f), productOf(b, h));
    }

    @Override
    public int[][] getBlockC21(int[][] m1, int[][] m2) throws RemoteException {
        int n = m1.length;


        // first matrix
        int[][] a = new int[n / 2][n / 2];
        int[][] b = new int[n / 2][n / 2];
        int[][] c = new int[n / 2][n / 2];
        int[][] d = new int[n / 2][n / 2];

        // second matrix
        int[][] e = new int[n / 2][n / 2];
        int[][] f = new int[n / 2][n / 2];
        int[][] g = new int[n / 2][n / 2];
        int[][] h = new int[n / 2][n / 2];

        // dividing matrix A into 4 parts
        divideMatrixIntoBlocks(m1, a, 0, 0);
        divideMatrixIntoBlocks(m1, b, 0, n / 2);
        divideMatrixIntoBlocks(m1, c, n / 2, 0);
        divideMatrixIntoBlocks(m1, d, n / 2, n / 2);


        // dividing matrix B into 4 parts
        divideMatrixIntoBlocks(m2, e, 0, 0);
        divideMatrixIntoBlocks(m2, f, 0, n / 2);
        divideMatrixIntoBlocks(m2, g, n / 2, 0);
        divideMatrixIntoBlocks(m2, h, n / 2, n / 2);


        // C11 =c*e + d*g


        return additionOf(productOf(c, e), productOf(d, g));
    }

    @Override
    public int[][] getBlockC22(int[][] m1, int[][] m2) throws RemoteException {
        int n = m1.length;


        // first matrix
        int[][] a = new int[n / 2][n / 2];
        int[][] b = new int[n / 2][n / 2];
        int[][] c = new int[n / 2][n / 2];
        int[][] d = new int[n / 2][n / 2];

        // second matrix
        int[][] e = new int[n / 2][n / 2];
        int[][] f = new int[n / 2][n / 2];
        int[][] g = new int[n / 2][n / 2];
        int[][] h = new int[n / 2][n / 2];

        // dividing matrix A into 4 parts
        divideMatrixIntoBlocks(m1, a, 0, 0);
        divideMatrixIntoBlocks(m1, b, 0, n / 2);
        divideMatrixIntoBlocks(m1, c, n / 2, 0);
        divideMatrixIntoBlocks(m1, d, n / 2, n / 2);


        // dividing matrix B into 4 parts
        divideMatrixIntoBlocks(m2, e, 0, 0);
        divideMatrixIntoBlocks(m2, f, 0, n / 2);
        divideMatrixIntoBlocks(m2, g, n / 2, 0);
        divideMatrixIntoBlocks(m2, h, n / 2, n / 2);


        // C22 =c*f + d*h


        return additionOf(productOf(c, f), productOf(d, h));
    }
}
