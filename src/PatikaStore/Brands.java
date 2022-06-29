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
    static TreeSet<Brands> brandsHashSet=new TreeSet<>(new Comparator<Brands>() {
        @Override
        public int compare(Brands o1, Brands o2) {
            return o1.getName().compareTo(o2.getName());
        }
    });

    public void printAllBrand(){
        System.out.println("Markalarımız");
        System.out.println("---------------");
        for (Brands str:brandsHashSet){
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

        brandsHashSet.add(new Brands(1,"Samsung"));
        brandsHashSet.add(new Brands(2,"Lenovo"));
        brandsHashSet.add(new Brands(3,"Apple"));
        brandsHashSet.add(new Brands(4,"Huawei"));
        brandsHashSet.add(new Brands(5,"Casper"));
        brandsHashSet.add(new Brands(6,"Asus"));
        brandsHashSet.add(new Brands(7,"HP"));
        brandsHashSet.add(new Brands(8,"Xiaomi"));
        brandsHashSet.add(new Brands(9,"Monster"));
    }






}
