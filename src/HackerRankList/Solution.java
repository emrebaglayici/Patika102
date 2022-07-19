package HackerRankList;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("How many element you want to insert initial list ? ");
        int n =Integer.parseInt(scanner.nextLine());
        List<Integer> list=new ArrayList<>(n);
        Integer input;
        for (int i = 0; i < n; i++) {
            input=Integer.parseInt(scanner.next().trim());
            list.add(input);

        }


    }
}
