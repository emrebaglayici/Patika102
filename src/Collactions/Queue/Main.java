package Collactions.Queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<String> queue=new LinkedList<>();
        queue.add("Alex");
        queue.add("De");
        queue.add("Souza");

        System.out.println(queue.poll());
        System.out.println("--------------");
        Iterator<String> iterator=queue.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
