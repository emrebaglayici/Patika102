package HackerRankDequeue;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        List<ArrayList<Integer>> all=new ArrayList<>();
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();
        // m is the sub array size , n is the size of total number of integers
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.addLast(num);
        }
        int counter=0;
        Deque<Integer> subArrList = new ArrayDeque<>(m);
        Deque<Integer> removedList=new ArrayDeque<>();
        for (int i = 0; i < deque.size(); i++) {
            int tempCount=0;
            for (int j = 0; j < m; j++) {
                int retr= (int) deque.getFirst();
                subArrList.addLast(retr);
                int removed= (int) deque.removeFirst();
                if (counter>=1)
                    removedList.addLast(removed);
                if (removedList.size()==m){
                    System.out.println(removedList.toString());
                    all.add((ArrayList<Integer>) removedList);
                    removedList.removeFirst();
                }
                counter++;
            }

            System.out.println(subArrList.toString());

        }

        System.out.println(all.toString());
    }
    public static int uniqueNumbers(Deque<Integer> list) {
        int counter = 0;
        for (int i = 0; i < list.size(); i++) {
            int removed = list.removeFirst();
            if (!list.isEmpty()){

                if (removed != list.peekFirst()) {
                    counter++;
                }
            }
        }
        return counter;
    }

}
