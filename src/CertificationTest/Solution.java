package CertificationTest;

import java.io.*;
import java.util.*;


public class Solution {
    public static int sum(Integer[] ar) {
        int sum = 0;
        for (Integer integer : ar) {
            sum = sum + integer;
        }
        return sum;
    }

    public static String sum(String[] ar) {
        String sum = "";
        for (String s : ar) {
            sum = sum + s;
        }
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) throws IOException {
        String input = scanner.nextLine();
        String[] numbers = input.split(" ");
        Integer[] arr = new Integer[numbers.length];
        try {
            for (int i = 0; i < numbers.length; i++) {
                arr[i] = Integer.valueOf(numbers[i]);
            }
            System.out.println(sum(arr));
        } catch (NumberFormatException e) {
            System.out.println(sum(numbers));
        }


    }
}