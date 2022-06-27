package Collactions.TreeMap;

public class Student {
    private Integer no;
    private String name;
    private Integer note;

    public Student(Integer no, String name, Integer note) {
        this.no = no;
        this.name = name;
        this.note = note;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }
}
