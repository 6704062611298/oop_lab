/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4;

/**
 *
 * @author intel
 */
public class MatrixMultiplication {
    private int[][] A;
    private int[][] B;

    MatrixMultiplication(int[][] A, int[][] B) {
        this.A = A;
        this.B = B;
    }

    public int[][] multiply() {

        int rA = A.length;
        int cA = A[0].length;

        int rB = B.length;
        int cB = B[0].length;

        int[][] C = new int[rA][cB];

        for (int i = 0; i < rA; i++) {

            for (int j = 0; j < cB; j++) {

                for (int k = 0; k < cA; k++) {

                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    }
    public static void main(String[]args){
        int arrA[][] = {{1,2,3},{3,4,2},{4,4,1}};
        int arrB[][] = {{13,2,3},{3,15,2},{55,4,1}};
        
        MatrixMultiplication M = new MatrixMultiplication(arrA,arrB);
        int c[][] =  M.multiply();
        for(int i = 0;i<c.length;i++){
            for (int j = 0;j<c[0].length;j++){
                System.out.print(c[i][j]+" ");
            }
            System.out.println();
        }
        
    }
}
