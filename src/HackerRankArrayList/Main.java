package HackerRankArrayList;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<List<Integer>> lines = new ArrayList<>();
        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            List<Integer> list = new ArrayList<>();
            int numbers = scanner.nextInt();
            for (int j = 0; j < numbers; j++) {
                list.add(scanner.nextInt());
            }
            lines.add(list);
        }


        int X = scanner.nextInt();
        for (int i = 0; i < X; i++) {
            int whichLine = scanner.nextInt();
            int whichIndex = scanner.nextInt();
            if(whichIndex>lines.get(whichLine-1).size()){
                System.out.println("ERROR");
            }else
              System.out.println(lines.get(whichLine-1).get(whichIndex-1));

        }

    }
}
