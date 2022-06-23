package Generics.GenericInterface;

public interface IDatabase<T> {
    boolean add(T data);

    boolean update(T data);

    boolean delete(T data);

    boolean select();
}
