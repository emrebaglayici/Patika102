package PatikaStore;

public class Product{
    private int id;
    private String name;
    private double price;
    private Brands brand;
    private int storage;
    private float inch;
    private int ram;

    public Product(int id, String name, double price, Brands brand, int storage, float inch, int ram) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.storage = storage;
        this.inch = inch;
        this.ram = ram;
    }

    public Product() {}

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

    public double getPrice() {
        return price;
    }

    public Brands getBrand() {
        return brand;
    }

    public int getStorage() {
        return storage;
    }

    public float getInch() {
        return inch;
    }

    public int getRam() {
        return ram;
    }

}
