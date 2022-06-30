package PatikaStore;

import java.util.*;

public class Brands {
    Integer id;
    String name;

    public Brands(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public Brands(){

    }
    public Brands(String name){
        this.name=name;
    }
    static TreeSet<Brands> brands=new TreeSet<>(new Comparator<Brands>() {
        @Override
        public int compare(Brands o1, Brands o2) {
            return o1.getName().compareTo(o2.getName());
        }
    });

    public void printAllBrand(){
        System.out.println("Our Brands");
        System.out.println("---------------");
        for (Brands str:brands){
            System.out.println("- "+str.name);
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    static {

        brands.add(new Brands(1,"Samsung"));
        brands.add(new Brands(2,"Lenovo"));
        brands.add(new Brands(3,"Apple"));
        brands.add(new Brands(4,"Huawei"));
        brands.add(new Brands(5,"Casper"));
        brands.add(new Brands(6,"Asus"));
        brands.add(new Brands(7,"HP"));
        brands.add(new Brands(8,"Xiaomi"));
        brands.add(new Brands(9,"Monster"));
    }

}
