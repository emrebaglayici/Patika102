package Generics.GenericInterface;

public class Student<T> implements IDatabase<T>{
    @Override
    public boolean add(T data) {
        System.out.println("Student added ! " + data);
        return false;
    }

    @Override
    public boolean update(T data) {
        System.out.println("Student updated ! ");
        return false;
    }

    @Override
    public boolean delete(T data) {
        System.out.println("Student deleted ! ");
        return false;
    }

    @Override
    public boolean select() {
        System.out.println("Student selected ! ");
        return false;
    }
}
