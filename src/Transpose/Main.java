package Transpose;

import java.util.Scanner;

public class Main {
    public static final Scanner input = new Scanner(System.in);

    public static int[][] transposeMatrix(int[][] matrix) {

        int[][] transpose = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }

    public static void printMatrix(int[][] matrix) {
        System.out.println("Matrix ------------ ");
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }

    public static void printTranspose(int[][] matrix) {
        System.out.println("Transpose ---------- ");
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] takeArraySize(){
        System.out.print("Matrix kaç satır olsun : ");
        int row=input.nextInt();
        System.out.print("Matrix kaç sütun olsun : ");
        int column=input.nextInt();
        return new int[row][column];
    }
    public static void takeArrayElements(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("Enter "+i+". row "+j+". column : ");
                matrix[i][j]=input.nextInt();
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix=takeArraySize();
        takeArrayElements(matrix);
        printMatrix(matrix);
        printTranspose(transposeMatrix(matrix));
    }
}
