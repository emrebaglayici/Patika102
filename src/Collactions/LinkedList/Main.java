package Collactions.LinkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list=new LinkedList<>();
        list.add("Emre");
        list.add("Elif");
        list.add("Şenol");

        Iterator<String> iterator= list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("---------------------");
        for(String value:list){
            System.out.println(value);
        }
    }
}
