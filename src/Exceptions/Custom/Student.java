package Exceptions.Custom;

public class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setAge(int age) throws IllegalArgumentException{
        if(age<0){
            throw new IllegalArgumentException("Age cannot be smaller than 0");
        }
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static Student find(int id) throws StudentException {
        if(id==123){
            return new Student(123,"Emre");
        }
        else {
            throw new StudentException("Student not found");
        }
    }

    public static void main(String[] args) {
        Student student=null;
        try {
            student=Student.find(123);
            System.out.println("Id "+student.getId());
            System.out.println("Name : "+student.getName());
        }catch (StudentException s){
            System.out.println(s.getMessage());
        }
    }
}
