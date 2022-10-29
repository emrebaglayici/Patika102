package HackerRankBillDivision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

 class Result{
    public static void bonAppetit(List<Integer> bill, int k, int b) {
        int bActual = 0;
        for (int i = 0; i < bill.size(); i++) {
            if (i==k)
                continue;
            bActual+= bill.get(i);
        }
        bActual=bActual/2;
        if (b ==bActual){
            System.out.println("Bon Appetit");
        } else{
            System.out.println(b-bActual);
        }
    }
}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> bill = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int b = Integer.parseInt(bufferedReader.readLine().trim());

        Result.bonAppetit(bill, k, b);

        bufferedReader.close();
    }
}
