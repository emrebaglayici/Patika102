package AdventureGame;

public class Weapon {
    private String name;
    private Integer id;
    private Integer damage;
    private Integer price;

    public Weapon(String name, Integer id, Integer damage, Integer price) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.price = price;
    }

    public static Weapon[] weapons(){
        Weapon[] weapons=new Weapon[3];
        weapons[0]=new Weapon("Gun",1,2,2);
        weapons[1]=new Weapon("Sword",2,3,35);
        weapons[2]=new Weapon("Rifle",3,7,45);
        return weapons;
    }

    public static Weapon getWeaponById(int selection) {
        for (Weapon weapon:weapons()){
            if(weapon.getId()==selection){
                return weapon;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
