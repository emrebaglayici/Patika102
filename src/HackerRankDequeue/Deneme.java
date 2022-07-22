package HackerRankDequeue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

public class Deneme {
    public static void main(String[] args) {
        Deque<Integer> s=new ArrayDeque<>();
        s.add(1);
        s.add(3);
        s.add(3);
        s.add(4);
        s.remove();
        System.out.println(s.contains(3));
        System.out.println(s.toString());
    }
}
