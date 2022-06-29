package PatikaStore;

import java.util.List;

public class Store {
    private String name;
    private List<List<Brands>> brands;
    private Product products;

    public Store(String name, List<List<Brands>> brands, Product products) {
        this.name = name;
        this.brands = brands;
        this.products = products;
    }
    public Store(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<List<Brands>> getBrands() {
        return brands;
    }

    public void setBrands(List<List<Brands>> brands) {
        this.brands = brands;
    }

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }
}
