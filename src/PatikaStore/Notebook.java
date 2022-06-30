package PatikaStore;

import java.util.*;

public class Notebook extends Product {
    TreeSet<Notebook> notebooks = new TreeSet<>(new Comparator<Notebook>() {
        @Override
        public int compare(Notebook o1, Notebook o2) {
            return o1.getId() - o2.getId();
        }
    });

    public Notebook(int id, String name, double price, Brands brand, int storage, float inch, int ram) {
        super(id, name, price, brand, storage, inch, ram);
    }

    public TreeSet<Notebook> notebooks() {

        notebooks.add(new Notebook(
                1, "HUAWEI Matebook 14 ",
                7000.0, new Brands("Huawei"), 512,
                14.0f, 16
        ));

        notebooks.add(new Notebook(
                2, "LENOVO V14 IGL",
                3699.0, new Brands("Lenovo"), 1024,
                14.0f, 8
        ));
        notebooks.add(new Notebook(
                3, "ASUS Tuf Gaming",
                8199.0, new Brands("Asus"), 2048,
                15.6f, 32
        ));
        return notebooks;

    }

    public TreeSet<Notebook> addNotebook(Notebook notebook) {
        this.notebooks.add(notebook);
        return notebooks;
    }

    public void removeNotebook(int id) {
        System.out.println(notebooks.removeIf(notebook -> notebook.getId() == id));
    }

    public TreeSet<Notebook> filterById(int id) {
        for (Notebook notebook:notebooks) {
            if(notebook.getId()==id)
                printBy(notebook);
        }
        return null;
    }

    public TreeSet<Notebook> filterByBrand(String brand) {
        for (Notebook notebook:notebooks) {
            if(notebook.getBrand().getName().equals(brand))
                printBy(notebook);
        }
        return null;
    }

    public void printBy(Notebook notebook) {
        System.out.println("Notbook Listesi");
        System.out.println("-----------------");
        String format = "|%1$-2s|%2$-20s|%3$-20s|%4$-10s|%5$-10s|%6$-20s|%7$-5s|\n";
        System.out.format(format, "ID",
                "Ürün Adı",
                "Fiyat",
                "Marka",
                "Depolama",
                "Ekran",
                "RAM");
        System.out.println();
        System.out.format(format, notebook.getId(),
                notebook.getName(),
                notebook.getPrice(),
                notebook.getBrand().getName(),
                notebook.getStorage(),
                notebook.getInch(),
                notebook.getRam());

    }

    public void printAllNotebooks() {
        System.out.println("Notbook Listesi");
        System.out.println("-----------------");
        String format = "|%1$-2s|%2$-20s|%3$-20s|%4$-10s|%5$-10s|%6$-20s|%7$-5s|\n";
        System.out.format(format, "ID",
                "Ürün Adı",
                "Fiyat",
                "Marka",
                "Depolama",
                "Ekran",
                "RAM");
        System.out.println();
        for (Notebook notebook : notebooks) {
            System.out.format(format, notebook.getId(),
                    notebook.getName(),
                    notebook.getPrice(),
                    notebook.getBrand().getName(),
                    notebook.getStorage(),
                    notebook.getInch(),
                    notebook.getRam());
        }


    }

    public Notebook() {
        super();
        this.notebooks();
    }
}
