package AdventureGame.GameCharacter;

import AdventureGame.Location.NormalLocation.ToolStore.Armor;
import AdventureGame.Location.NormalLocation.ToolStore.Weapon;

public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private String loot;
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

    public String getLoot() {
        return loot;
    }

    public void setLoot(String loot) {
        this.loot = loot;
    }
}
