package Exceptions;

import java.util.Scanner;

public class Throws {
    public static void checkAge(int age) throws Exception{
        if(age<18){
            throw new ArithmeticException("Hatalı yaş");
        }
        System.out.println("Muaf");
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Yaş giriniz : ");
        int age= scanner.nextInt();

        try {
            checkAge(age);
        } catch (Exception e) {
            System.out.println("Yaşı küçük sanırım");
            System.out.println(e.toString());
        }
    }
}
