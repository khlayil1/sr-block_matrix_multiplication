import java.io.DataInputStream;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    public static void main(String[] args) throws Exception {
        DataInputStream inputStream = new DataInputStream(System.in);

        int order;

        int[][] mat1;
        int[][] mat2;


        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1888);

        MatrixServiceFactory matrixServiceFactory = (MatrixServiceFactory) registry.lookup("matrixProduct");

        if (matrixServiceFactory != null) {
            System.out.println(" Connected to server ");
        } else {
            System.out.println(" Connection failed ");
        }
        System.out.print("Please define the matrix order:");
        order = new Integer(inputStream.readLine());

        System.out.println("Matrix number 1: ");

        mat1 = readMatrix(order);

        System.out.println("Matrix number 2: ");


        mat2 = readMatrix(order);

        System.out.println("M1 : ");
        System.out.println("~~~~~");
        printMatrix(mat1);

        System.out.println("M2 : ");
        System.out.println("~~~~~");
        printMatrix(mat2);
        int[][] product = new int[order][order];

        if (matrixServiceFactory != null) {
            int[][] C11 = matrixServiceFactory.newMatrixService().getBlockC11(mat1, mat2);
            int[][] C12 = matrixServiceFactory.newMatrixService().getBlockC12(mat1, mat2);
            int[][] C21 = matrixServiceFactory.newMatrixService().getBlockC21(mat1, mat2);
            int[][] C22 = matrixServiceFactory.newMatrixService().getBlockC22(mat1, mat2);


            joinBlocks(C11, product, 0, 0);
            joinBlocks(C12, product, 0, order / 2);
            joinBlocks(C21, product, order / 2, 0);
            joinBlocks(C22, product, order / 2, order / 2);
            System.out.println("the product of M1 and M2 is : ");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            printMatrix(product);
        } else
            System.out.println("server unavailable");

    }

    private static int[][] readMatrix(int order) throws Exception {
        DataInputStream inputStream = new DataInputStream(System.in);

        int[][] t;
        int i;
        int j;

        t = new int[order][order];

        for (i = 0; i < t.length; i = i + 1)
            for (j = 0; j < t[0].length; j = j + 1) {
                System.out.print(" [" + (i + 1) + "," + (j + 1) + "]:");
                String ch = inputStream.readLine();
                Integer numb = new Integer(ch);
                t[i][j] = numb;
            }

        return t;
    }

    private static void printMatrix(int[][] m) {

        try {
            int columns = m[0].length;
            StringBuilder str = new StringBuilder("|\t");
            StringBuilder row = new StringBuilder("+");
            for (int j = 0; j < columns; j++) {
                row.append("-------+");
            }
            for (int[] ints : m) {
                for (int j = 0; j < columns; j++) {
                    str.append(ints[j]).append("\t|\t");
                }

                System.out.println(row);
                System.out.println(str);
                str = new StringBuilder("|\t");

            }
            System.out.println(row);

        } catch (Exception e) {
            System.out.println("Matrix is empty!!");
        }
    }

    private static void joinBlocks(int[][] C, int[][] P, int iB, int jB) {
        for (int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for (int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
                P[i2][j2] = C[i1][j1];
    }
}
