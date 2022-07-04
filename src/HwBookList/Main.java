package HwBookList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Book book1=new Book("A",100,"Emre","1610996");
        Book book2=new Book("B",120,"Elif","1610996");
        Book book3=new Book("C",140,"Ahmet","1610996");
        Book book4=new Book("D",200,"Mehmet","1610996");
        Book book5=new Book("E",1007,"Şenol","1610996");
        Book book6=new Book("F",87,"Fatih","1610996");
        Book book7=new Book("G",40,"Simay","1610996");
        Book book8=new Book("H",76,"Miray","1610996");
        Book book9=new Book("I",278,"Hakan","1610996");
        Book book10=new Book("O",456,"Erkan","1610996");

        ArrayList<Book> bookList=new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        bookList.add(book5);
        bookList.add(book6);
        bookList.add(book7);
        bookList.add(book8);
        bookList.add(book9);
        bookList.add(book10);

//        Map<String,String> map=bookList.stream().collect(Collectors.groupingBy(t -> t.getAuthorName(),t->t.));
        Map<String,String> carMap=new HashMap<>();
        bookList.forEach(book->carMap.put(book.getName(),book.getAuthorName()));

        carMap.forEach((x,y)-> System.out.println(x+" "+y));

        List<Book> book=bookList.stream().filter(a -> a.getPageNumber() > 100).toList();

    }
}
