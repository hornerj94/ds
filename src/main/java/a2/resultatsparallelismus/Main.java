package a2.resultatsparallelismus;

import a2.masterworker.Master;
import a2.utils.Matrix;

public class Main {
    // ---------------------------------------------------------------------------------------------

    public static void main(String[] args) {

        int [][] rowsA = {{  1, -2,  3,  4, -1 },
                          { -2,  3,  0,  1,  2 },
                          {  4, -1,  2,  1, -2 },
                          { -2,  1,  3, -1,  3 },
                          {  0,  2, -1,  2,  4 }};
        
        int [][] rowsB = {{  2, -4, -1,  1, -2 },
                          { -1,  1, -2,  2,  1 },
                          {  5,  0,  3, -2, -4 },
                          {  1, -2,  1,  0,  2 },
                          {  2,  3, -3,  0,  0 }};

        Matrix matrixA = new Matrix();
        matrixA.setRows(rowsA);
        Matrix matrixB = new Matrix();
        matrixB.setRows(rowsB);
        Matrix matrixC = new Matrix();
        
        Master masterThread = new Master();
        masterThread.setMatrixA(matrixA);
        masterThread.setMatrixB(matrixB);
        
        int threadAmount = 0;
        try {
            threadAmount = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Der übergebene Parameter war keine Zahl oder hatte das "
                    + "falsche Format");
        } catch (IndexOutOfBoundsException e2) { 
            System.out.println("Es muss ein Parameter übergeben werden");
        }
        masterThread.setThreadNumber(threadAmount);
        
        masterThread.start();  
        
        try {
            masterThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        matrixC = masterThread.getMatrixC();
        if (matrixC != null) {
            matrixC.printMatrix();
        }
    }
    
    // ---------------------------------------------------------------------------------------------
}
