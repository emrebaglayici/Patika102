package Stream;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList=new ArrayList();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.add(40);
        arrayList.add(40);
        arrayList.add(40);
        arrayList.add(50);
        arrayList.add(60);
        arrayList.add(70);
        arrayList.add(70);
        arrayList.add(70);

//        arrayList.forEach(System.out::println);
//        arrayList.stream().filter(num->num>40).forEach(System.out::println);
//        arrayList.stream().filter(num->num>45).distinct().forEach(System.out::println);
//        arrayList.stream().distinct().sorted(Comparator.reverseOrder()).forEach(System.out::println);
//        arrayList.stream().limit(5).forEach(System.out::println);
//        arrayList.stream().skip(2).limit(5).forEach(System.out::println);

//        long c=arrayList.stream().filter(num->num>40).distinct().count();
//        System.out.println(c);

        boolean control=arrayList.stream().anyMatch(i->i==70);
        System.out.println(control);

        arrayList.stream().map(i->i*2).forEach(System.out::println);
        int min=arrayList.stream().min(Integer::compare).get();
        System.out.println(min);
    }
}
