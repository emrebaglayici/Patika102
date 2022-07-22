package HackerRankBitSet;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int operationCount = scanner.nextInt();
        BitSet B1 = new BitSet(n);
        BitSet B2 = new BitSet(n);


        for (int i = 0; i < operationCount; i++) {
            String str = scanner.next();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (str.equals("AND")) {
                if (a==1 && b==2){
                    B1.and(B2);
                } else if (a==2 && b==1) {
                    B2.and(B1);
                } else if (a==1 && b==1) {
                    B1.and(B1);
                } else if (a==2 && b==2) {
                    B2.and(B2);
                }
            } else if (str.equals("SET")) {
                if (a==1){
                    B1.set(b);
                }else if (a==2){
                    B2.set(b);
                }
            } else if (str.equals("FLIP")) {
                if (a==1){
                    B1.flip(b);
                }else if (a==2){
                    B2.flip(b);
                }
            } else if (str.equals("OR")) {
                if (a==1 && b==2){
                    B1.or(B2);
                } else if (a==2 && b==1) {
                    B2.or(B1);
                } else if (a==1 && b==1) {
                    B1.or(B1);
                } else if (a==2 && b==2) {
                    B2.or(B2);
                }
            } else if (str.equals("XOR")) {
                if (a==1 && b==2){
                    B1.xor(B2);
                } else if (a==2 && b==1) {
                    B2.xor(B1);
                } else if (a==1 && b==1) {
                    B1.xor(B1);
                } else if (a==2 && b==2) {
                    B2.xor(B2);
                }
            }
            System.out.println(B1.cardinality()+ " "+B2.cardinality());
        }




    }
}
