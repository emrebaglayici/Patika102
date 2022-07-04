package HwBookList;

public class Book{
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
        return "Book{" +
                "name='" + name + '\'' +
                ", pageNumber=" + pageNumber +
                ", authorName='" + authorName + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
