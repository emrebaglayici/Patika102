package Collactions.PriorityQueue;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Example {
    public static void main(String[] args) {
        Comparator<Integer> compareForEven = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int result = o1 % 2 - o2 % 2;
                if (result == 0) {
                    result = o1 - o2;
                }
                return result;
            }
        };
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(20,compareForEven);
        for (int i = 0; i < 20; i++) {
           priorityQueue.add(20-i);

        }
        for (int i = 0; i < 20; i++) {
            System.out.print("\t"+priorityQueue.poll());
        }
    }
}
