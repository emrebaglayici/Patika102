package AdventureGame.GameCharacter;

import AdventureGame.Location.NormalLocation.ToolStore.Armor;
import AdventureGame.Location.NormalLocation.ToolStore.Weapon;

public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private int food;
    private int fireWood;
    private int water;
    public Inventory() {
        this.weapon = new Weapon("Punch",-1,0,0);
        this.armor=new Armor(-1,"No-Armor",0,0);
    }


    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getFireWood() {
        return fireWood;
    }

    public void setFireWood(int fireWood) {
        this.fireWood = fireWood;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }
}
