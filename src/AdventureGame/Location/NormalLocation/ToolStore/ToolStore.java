package AdventureGame.Location.NormalLocation.ToolStore;

import AdventureGame.GameCharacter.Player;
import AdventureGame.Location.NormalLocation.NormalLocation;

public class ToolStore extends NormalLocation {
    public ToolStore(Player player) {
        super( player, "Tool Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Welcome to the tool store!");
        boolean showMenu=true;
        while (showMenu){
            System.out.println("To see : weapons type 1 \t armors type 2 \t exit 3 \t");
            int selection = input.nextInt();
            while (selection < 1 || selection > 3) {
                System.out.println("Invalid typo");
                selection = input.nextInt();
            }
            switch (selection) {
                case 1:
                    printWeapons();
                    purchaseWeapon();
                    break;
                case 2:
                    printArmors();
                    purchaseArmor();
                    break;
                case 3:
                    System.out.println("See you again");
                    showMenu=false;
                    break;
            }

        }
        return true;
    }

    private void purchaseArmor() {
        System.out.println("Select a armor");
        int selection = input.nextInt();
        while (selection < 0 || selection > Armor.armors().length) {
            System.out.println("Invalid armor id");
            selection = input.nextInt();
        }
        if (selection!=0){
            Armor selectedArmor = Armor.getArmorById(selection);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Not enough found");
                } else {
                    System.out.println(selectedArmor.getName() + " zırhını satın aldınız.");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız : " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                }
            }
        }



    }

    public void printWeapons() {
        System.out.println("Weapons");
        for (Weapon w : Weapon.weapons()) {
            System.out.println("Weapon Id : " + w.getId() +
                    "\t name : " + w.getName() +
                    "\t damage : " + w.getDamage() +
                    "\t price : " + w.getPrice());
        }
        System.out.println("0- to exit");

    }

    public void purchaseWeapon() {
        System.out.println("Select a weapon");
        int selection = input.nextInt();
        while (selection < 0 || selection > Weapon.weapons().length) {
            System.out.println("Invalid weapon id");
            selection = input.nextInt();
        }

        if(selection!=0){
            Weapon selectedWeapon = Weapon.getWeaponById(selection);
            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Not enough found");
                } else {
                    System.out.println(selectedWeapon.getName() + " silahı satın aldınız.");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız : " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                }
            }
        }
    }

    public void printArmors() {
        System.out.println("Armors");
        for (Armor a : Armor.armors()) {
            System.out.println("Armors Id : " + a.getId() +
                    "\t name : " + a.getName() +
                    "\t block : " + a.getBlock() +
                    "\t price : " + a.getPrice());
        }
        System.out.println("0- to exit");
    }
}
