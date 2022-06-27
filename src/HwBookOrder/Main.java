package HwBookOrder;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Book book1=new Book("A",100,"Elif"
        ,"19012019");

        Book book2=new Book("B",125,"Emre"
                ,"16101996");

        Book book3=new Book("C",630,"Kamil"
                ,"15152015");

        Book book4=new Book("D",789,"Mehmet"
                ,"04022002");

        Book book5=new Book("E",145,"Cüneyt"
                ,"03042015");

        HashSet<Book> bookSets=new HashSet<Book>();

        bookSets.add(book1);
        bookSets.add(book2);
        bookSets.add(book3);



        for (Book book:bookSets){
            System.out.println(book.getName());
        }
        System.out.println("------------------------------");


        TreeSet<Book> bookSet1=new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPageNumber()-o2.getPageNumber();
            }
        });
        bookSet1.add(book1);
        bookSet1.add(book2);
        bookSet1.add(book3);
        bookSet1.add(book4);
        bookSet1.add(book5);

        for (Book book:bookSet1){
            System.out.println(book.getName()+" "+book.getPageNumber());
        }

    }
}
