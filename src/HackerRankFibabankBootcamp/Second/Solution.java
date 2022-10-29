package HackerRankFibabankBootcamp.Second;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'findMaximumMoneyEarned' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY cost
     *  2. INTEGER x
     */

    public static int findMaximumMoneyEarned(List<Integer> cost, int x) {
        List<Integer> list=new ArrayList<>();
        int total = 0;
        int calc=0;

        for (int i = 0; i < cost.size(); i++) {
            total=cost.get(i);
            calc= (int) Math.pow(2,i);
            for (int j = i+1; j < cost.size(); j++) {
                if (total<x) {
                    total += cost.get(j);
                    calc += Math.pow(2, j);
                    list.add(calc);
                }
            }

        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
//        int max=0;
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i)>max)
//                max= list.get(i);
//        }
//        System.out.println(max);
//        return max;
        return 0;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.out.toString()));

        int costCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> cost = IntStream.range(0, costCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int x = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.findMaximumMoneyEarned(cost, x);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
