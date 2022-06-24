package Exceptions.HackerRank;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int x,y;
        try {
            x=scanner.nextInt();
            y=scanner.nextInt();
            System.out.println(x/y);
        }catch (InputMismatchException i){
            System.out.println("java.util.InputMismatchException");
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
