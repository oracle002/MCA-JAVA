import java.util.Scanner;

public class MatrixMultiplication {  
    public static void main(String args[]) {  
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the dimensions of the matrices
        System.out.print("Enter the number of rows for matrix A: ");
        int rowsA = scanner.nextInt();
        System.out.print("Enter the number of columns for matrix A: ");
        int colsA = scanner.nextInt();

        System.out.print("Enter the number of rows for matrix B: ");
        int rowsB = scanner.nextInt();
        System.out.print("Enter the number of columns for matrix B: ");
        int colsB = scanner.nextInt();

        // Check if matrix multiplication is possible
        if (colsA != rowsB) {
            System.out.println("Matrix multiplication is not possible.");
            return;
        }

        // Creating matrices based on user input
        int a[][] = new int[rowsA][colsA];
        int b[][] = new int[rowsB][colsB];
        
        // Input matrix A
        System.out.println("Enter elements for matrix A:");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                System.out.print("Enter element [" + i + "][" + j + "]: ");
                a[i][j] = scanner.nextInt();
            }
        }

        // Input matrix B
        System.out.println("Enter elements for matrix B:");
        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                System.out.print("Enter element [" + i + "][" + j + "]: ");
                b[i][j] = scanner.nextInt();
            }
        }

        // Creating another matrix to store the multiplication of two matrices    
        int c[][] = new int[rowsA][colsB];  
        
        // Multiplying and printing multiplication of 2 matrices    
        for (int i = 0; i < rowsA; i++) {    
            for (int j = 0; j < colsB; j++) {    
                c[i][j] = 0;      
                for (int k = 0; k < colsA; k++) {      
                    c[i][j] += a[i][k] * b[k][j];      
                }//end of k loop  
                System.out.print(c[i][j] + " ");  //printing matrix element  
            }//end of j loop  
            System.out.println();//new line    
        }    

        scanner.close(); // Close the scanner
    }
}
