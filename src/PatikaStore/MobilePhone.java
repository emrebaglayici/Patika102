package PatikaStore;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

public class MobilePhone extends Product {
    private int camera;
    private int battery;
    private String color;
    static TreeSet<MobilePhone> mobilePhones = new TreeSet<>(new Comparator<MobilePhone>() {
        @Override
        public int compare(MobilePhone o1, MobilePhone o2) {
            return o1.getId()-o2.getId();
        }
    });


    public MobilePhone(int id, String name, double price,
                       Brands brand, int storage, float inch, int camera,
                       int battery, String color, int ram) {
        super(id, name, price, brand, storage, inch, ram);
        this.camera = camera;
        this.battery = battery;
        this.color = color;
    }

    static {
        mobilePhones.add(new MobilePhone(
                1, "GALAXY A51",
                3199.0, new Brands("Samsung"), 128,
                6.5f, 32, 4000, "Siyah", 6
        ));

        mobilePhones.add(new MobilePhone(
                2, "iPhone 11",
                7379.0, new Brands("Apple"), 64,
                6.1f, 5, 3046, "Mavi", 6
        ));

        mobilePhones.add(new MobilePhone(
                3, "Redmi Note 10 Pro",
                4012.0, new Brands("Xiaomi"), 128,
                6.5f, 35, 4000, "Beyaz", 12
        ));

    }

    public MobilePhone() {

    }

    public void printAllMobilePhones() {
        System.out.println("Mobile Phone List");
        System.out.println("-----------------");
        String format = "|%1$-2s|%2$-25s|%3$-20s|%4$-10s|%5$-10s|%6$-20s|%7$-5s|" +
                "%8$-5s|%9$-5s|%10$-5s|\n";
        System.out.format(format, "ID",
                "Ürün Adı",
                "Fiyat",
                "Marka",
                "Depolama",
                "Ekran",
                "Kamera",
                "Pil",
                "Ram",
                "Renk");
        System.out.println();
        for (MobilePhone mobilePhone : mobilePhones) {
            System.out.format(format, mobilePhone.getId(),
                    mobilePhone.getName(),
                    mobilePhone.getPrice(),
                    mobilePhone.getBrand().getName(),
                    mobilePhone.getStorage(),
                    mobilePhone.getInch(),
                    mobilePhone.getCamera(),
                    mobilePhone.getBattery(),
                    mobilePhone.getRam(),
                    mobilePhone.getColor());
        }
    }

    public int getCamera() {
        return camera;
    }

    public int getBattery() {
        return battery;
    }

    public String getColor() {
        return color;
    }
}
