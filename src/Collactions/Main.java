package Collactions;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Main {
    public static void main(String[] args) {
        //boyut vermemiz gerek yok , kendi genişleyecek
//        HashSet<Integer> hashSet=new HashSet<>();
//        hashSet.add(10);
//        hashSet.add(20);
//        hashSet.add(10);
//        hashSet.add(30);
//        hashSet.add(null);
////        for(Integer sayi:hashSet){
////            //tekrar eden verileri yazmaz
////            System.out.println(sayi);
////        }
//        Iterator<Integer> iterator=hashSet.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//        System.out.println(hashSet.size());
        LinkedHashSet<Integer> linkedHashSet=new LinkedHashSet<>();
        linkedHashSet.add(30);
        linkedHashSet.add(10);
        linkedHashSet.add(10);
        linkedHashSet.add(20);
        Iterator<Integer> iterator= linkedHashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
