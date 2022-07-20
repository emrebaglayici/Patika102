package HackerRankList;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("How many element you want to insert initial list ? ");
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> list = new ArrayList<>(n);
        Integer input;
        for (int i = 0; i < n; i++) {
            input = Integer.parseInt(scanner.next().trim());
            list.add(input);
        }
//        System.out.println("How many queries do you want ?");
        n=scanner.nextInt();
        Integer input2;
        for (int i = 0; i < n; i++) {
            String str= scanner.next();
            if (str.equals("Insert")){
                List<Integer> tempList=new ArrayList<>(n);
                for (int j = 0; j < 2; j++) {
                    input2=Integer.parseInt(scanner.next().trim());
                    tempList.add(input2);
                }
                list.add(tempList.get(0),tempList.get(1));
            }
            if (str.equals("Delete")){
                list.remove(Integer.parseInt(scanner.next().trim()));
            }


        }

        for (Integer i:list){
            System.out.print(i+" ");
        }
        scanner.close();

    }
}
