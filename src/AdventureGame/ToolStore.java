package AdventureGame;

public class ToolStore extends NormalLocation {
    public ToolStore(Player player) {
        super(2, player, "Tool Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Welcome to the tool store!");
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
                break;
            case 3:
                return true;
        }
        return true;
    }

    public void printWeapons() {
        System.out.println("Weapons");
        for (Weapon w : Weapon.weapons()) {
            System.out.println("Weapon Id : " + w.getId() +
                    "\t name : "+w.getName()+
                    "\t damage : " + w.getDamage() +
                    "\t price : " + w.getPrice());
        }

    }
    public void purchaseWeapon(){
        System.out.println("Select a weapon");
        int selection=input.nextInt();
        while (selection<1||selection>Weapon.weapons().length){
            System.out.println("Invalid weapon id");
            selection=input.nextInt();
        }

        Weapon selectedWeapon=Weapon.getWeaponById(selection);
        if(selectedWeapon!=null){
            if(selectedWeapon.getPrice()> this.getPlayer().getMoney()){
                System.out.println("Not enough found");
            }
            else {
                System.out.println(selectedWeapon.getName()+" silahı satın aldınız.");
                int balance=this.getPlayer().getMoney()-selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Kalan paranız : "+this.getPlayer().getMoney());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
            }
        }
    }

    public void printArmors() {
        System.out.println("Armors");
    }
}
