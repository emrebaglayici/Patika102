package Collactions.TreeMap;

import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TreeMap<Integer,Student> treeMap=new TreeMap<>(new OrderByNoComparator().reversed());

        treeMap.put(102,new Student(102,"Emre",100));
        treeMap.put(110,new Student(110,"John",25));
        treeMap.put(108,new Student(108,"Merkel",77));
        treeMap.put(118,new Student(118,"Biden",40));

        for(Student student:treeMap.values()){
            System.out.println(student.getName());
        }
    }
}
