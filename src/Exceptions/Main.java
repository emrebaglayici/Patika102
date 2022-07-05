package Exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int inp;
        try {
            System.out.println("Type String");
            String a=scanner.nextLine();
            int number=Integer.parseInt(a);
            System.out.println(number);


        }catch (Exception e){
            e.printStackTrace();


        }finally {
            scanner.close();
            System.out.println("This code always works.");
        }
    }
}
