package Collactions.Vector;

import java.util.Iterator;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Vector<String> vector=new Vector<>();
        vector.add("Emre");
        vector.add("Bağlayici");
        vector.add("Elif");

        vector.add(1,"Şenol");

        Iterator<String> iterator= vector.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for(String str:vector){
            System.out.println(str);
        }
    }
}
