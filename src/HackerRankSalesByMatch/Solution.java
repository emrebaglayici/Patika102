package HackerRankSalesByMatch;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {
    public static int sockMerchant(int n, List<Integer> ar) {
        List<Integer> seenValues=new ArrayList<>();
        int totalParis=0;
        for (int i = 0; i < n; i++) {
            if (!seenValues.contains(ar.get(i))){
                int counter=1;
                for (int j = i+1; j < n ; j++) {
                    if (Objects.equals(ar.get(i), ar.get(j))){
                        counter++;
                        if (!seenValues.contains(ar.get(i))){
                            seenValues.add(ar.get(i));
                        }
                    }
                }
                totalParis+=(counter/2);
            }
        }
        System.out.println(totalParis);
        return totalParis;

    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.out.toString()));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
