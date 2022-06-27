package Collactions.TreeSet;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Student> students=new TreeSet<>(new OrderNameComparator().reversed());
        students.add(new Student("Emre",20));
        students.add(new Student("Elif",100));
        students.add(new Student("Şenol",80));
        students.add(new Student("Elif",100));

        for (Student s:students){
            System.out.println(s.getName());
        }
    }
}
