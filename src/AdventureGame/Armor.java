package AdventureGame;

public class Armor {
    private Integer id;
    private String name;
    private Integer block;
    private Integer price;

    public Armor(Integer id, String name, Integer block, Integer price) {
        this.id = id;
        this.name = name;
        this.block = block;
        this.price = price;
    }

    public static Armor getArmorById(int selection) {
        for (Armor armor:armors()){
            if(armor.getId()==selection){
                return armor;
            }
        }
        return null;
    }
    public static Armor[] armors(){
        Armor[] armorList=new Armor[3];
        armorList[0]=new Armor(1,"Light",1,15);
        armorList[1]=new Armor(2,"Middle",3,25);
        armorList[2]=new Armor(3,"Heavy",5,40);

        return armorList;
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

    public Integer getBlock() {
        return block;
    }

    public void setBlock(Integer block) {
        this.block = block;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
