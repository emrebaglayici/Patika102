package Collactions.ArrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(null);
        arrayList.add(78);
        arrayList.add(65);
        System.out.println( arrayList.remove(0)+" silindi");

        arrayList.set(2,22);
        System.out.println(arrayList.size());
//       arrayList.add(5,98);
        System.out.println(arrayList.get(3));
//        Iterator<Integer> iterator= arrayList.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        for(Integer element:arrayList){
            System.out.println(element);
        }
    }
}
