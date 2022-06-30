package PatikaStore;

import java.util.TreeSet;

public interface IOperations {
    TreeSet<Product> add(Product product);
    void removeProduct(int id);
    TreeSet<Product> filterById(int id);
    TreeSet<Product> filterByBrand(String brand);
    void printBy(Product product);
    void printAllProducts();
}
