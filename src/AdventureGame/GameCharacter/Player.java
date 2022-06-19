package AdventureGame.GameCharacter;

import java.util.Scanner;

public class Player {
    private Integer damage;
    private Integer health;
    private Integer money;
    private String name;
    private String charName;
    private int defHealth;
    private Scanner input = new Scanner(System.in);
    private Inventory inventory;


    public Player(String name) {
        this.inventory = new Inventory();
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }


    public void selectChar() {
        GameChar[] gameChars = {new Samurai(), new Archer(), new Knight()};
        System.out.println("Characters");
        for (GameChar gameChar : gameChars) {
            System.out.println("Id : " + gameChar.getId() + "\t" +
                    "Character name : \t" + gameChar.getName() +
                    " Damage : \t" + gameChar.getDamage() +
                    " Health : \t" + gameChar.getHealth() +
                    " Money : \t" + gameChar.getMoney());
        }
        System.out.print("Pick a character = ");
        int selection = input.nextInt();
        switch (selection) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
                break;

        }

    }

    public int getDefHealth() {
        return defHealth;
    }

    public void setDefHealth(int defHealth) {
        this.defHealth = defHealth;
    }

    public void initPlayer(GameChar gameChar) {
        setDamage(gameChar.getDamage());
        setHealth(gameChar.getHealth());
        setDefHealth(gameChar.getHealth());
        setMoney(gameChar.getMoney());
        setCharName(gameChar.getName());
    }

    public int getTotalDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public void printInfo() {
        System.out.println("Your Weapon => " + this.getInventory().getWeapon().getName() +
                "\t Armor => " + this.getInventory().getArmor().getName() +
                "\t Block => " + this.getInventory().getArmor().getBlock() +
                "\t Damage => " + getDamage() +
                "\t Health => " + getTotalDamage() +
                "\t Money => " + getMoney());
    }
}
