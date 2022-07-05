package HwBookList;

import java.util.Comparator;
import java.util.List;

public class Book implements Comparator<Book> {
    private String name;
    private int pageNumber;
    private String authorName;
    private String date;

    public Book(String name, int pageNumber, String authorName, String date) {
        this.name = name;
        this.pageNumber = pageNumber;
        this.authorName = authorName;
        this.date = date;
    }
    public Book(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "BookName : " + name +
                "PageNumber=" + pageNumber +
                "AuthorName" + authorName +
                "Date" + date;
    }

    public void getAllBooks(List<Book> book){
        for(Book b:book){
            System.out.println(" "+b.getAuthorName()+
                    " "+b.getName()+" "+
                    b.getDate()+" "+
                    b.getPageNumber()+" \n");
        }
    }

    @Override
    public int compare(Book o1, Book o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
