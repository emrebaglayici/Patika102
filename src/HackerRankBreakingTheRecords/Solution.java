package HackerRankBreakingTheRecords;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {


    /*
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
        List<Integer> list=new ArrayList<>();
        int highest=Integer.MIN_VALUE;
        int lowest=Integer.MAX_VALUE;
        int countLow=0;
        int countHighest=0;
        for (int i = 0; i < scores.size()-1; i++) {
            if (i==0){
                highest=scores.get(0);
                lowest=scores.get(0);
                continue;
            }
            if (scores.get(i)>highest){
                countHighest++;
                highest= scores.get(i);
            }
            if (scores.get(i)<lowest){
                countLow++;
                lowest= scores.get(i);
            }
        }
        list.add(countHighest);
        list.add(countLow);
        return list;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {







        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(String.valueOf(System.out)));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.breakingRecords(scores);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

