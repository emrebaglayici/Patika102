package GenericsHomework;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> liste = new MyList<>();
        System.out.println("Array capacity : " + liste.getCapacity());
        System.out.println("Array element size : " + liste.size());
        liste.add(10);
        liste.add(20);
        liste.add(30);
        liste.add(40);
        System.out.println("Array capacity : " + liste.getCapacity());
        System.out.println("Array element size : " + liste.size());
        liste.add(50);
        liste.add(90);
        liste.add(70);
        liste.add(80);
        liste.add(90);
        liste.add(100);
        liste.add(110);
        System.out.println("Array capacity : " + liste.getCapacity());
        System.out.println("Array element size : " + liste.size());

//        list.remove(2);
//        System.out.println(list.set(1,12));
//        System.out.println(list.lastIndexOf(500));
//        System.out.println(list.isEmpty());
//        System.out.println(Arrays.toString(list.toArray()));
       // list.clear();

        /*MyList<Integer> alt=list.sublist(4,5);*/
//        System.out.println(alt.toString());
        System.out.println(liste.contains(50));
    }
}
