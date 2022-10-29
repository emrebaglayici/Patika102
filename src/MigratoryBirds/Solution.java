package MigratoryBirds;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {


    public static int migratoryBirds(List<Integer> arr) {

        int[] arrCount = new int[arr.size()];
        for(int n : arr) {
            arrCount[n]++;
        }
        int max = 0;
        int highBirdPose = 0;
        for(int i = 1; i < arrCount.length; i++) {
            if(arrCount[i] > max) {
                max = arrCount[i];
                highBirdPose = i;
            }
        }
        return highBirdPose;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.out.toString()));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
