package Exceptions;

import java.util.Scanner;

public class Throws {
    public static void checkAge(int age) throws Exception{
        if(age<18){
            throw new ArithmeticException("Invalid age");
        }
        System.out.println("OK");
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Type age : ");
        int age= scanner.nextInt();

        try {
            checkAge(age);
        } catch (Exception e) {
            System.out.println("His/Her age too young.");
            System.out.println(e.toString());
        }
    }
}
