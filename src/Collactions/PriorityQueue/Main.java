package Collactions.PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<String> priorityQueue=new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        }.reversed());

        priorityQueue.add("Joe");
        priorityQueue.add("John");
        priorityQueue.add("Doe");
        priorityQueue.add("Alex");

        for(String str:priorityQueue){
            System.out.println(str);
        }
    }
}
