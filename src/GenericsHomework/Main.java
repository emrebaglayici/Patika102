package GenericsHomework;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> liste = new MyList<>();
        System.out.println("Dizinin kapasitesi : " + liste.getCapacity());
        System.out.println("Dizideki eleman sayısı : " + liste.size());
        liste.add(10);
        liste.add(20);
        liste.add(30);
        liste.add(40);
        System.out.println("Dizinin kapasitesi : " + liste.getCapacity());
        System.out.println("Dizideki eleman sayısı : " + liste.size());
        liste.add(50);
        liste.add(90);
        liste.add(70);
        liste.add(80);
        liste.add(90);
        liste.add(100);
        liste.add(110);
        System.out.println("Dizinin kapasitesi : " + liste.getCapacity());
        System.out.println("Dizideki eleman sayısı : " + liste.size());

//        liste.remove(2);
//        System.out.println(liste.set(1,12));
//        System.out.println(liste.lastIndexOf(500));
//        System.out.println(liste.isEmpty());
//        System.out.println(Arrays.toString(liste.toArray()));
       // liste.clear();

        /*MyList<Integer> alt=liste.sublist(4,5);*/
//        System.out.println(alt.toString());
        System.out.println(liste.contains(50));
    }
}
