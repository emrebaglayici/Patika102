package AdventureGame.Location.BattleLocation;

import AdventureGame.Location.Location;
import AdventureGame.Location.BattleLocation.Obstacle.Obstacle;
import AdventureGame.GameCharacter.Player;

import java.util.Random;

public abstract class BattleLocation extends Location {
    private Obstacle obstacle;
    private int maxObstacle;
    private int remainingObstacle;
    private String award;

    public BattleLocation(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

//    public BattleLocation(Player player, String name, Obstacle obstacle, String award) {
//        super(player, name);
//        this.obstacle = obstacle;
//        this.award = award;
//    }

//    public BattleLocation(Player player, String name, Obstacle obstacle, Award normalAward, int maxObstacle) {
//        super(player, name);
//        this.obstacle = obstacle;
//        this.maxObstacle = maxObstacle;
//        this.normalAward = normalAward;
//    }

    public String getNormalAward() {
        return award;
    }

    public void setNormalAward(String award) {
        this.award = award;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        setRemainingObstacle(obsNumber);
        System.out.println("You are now in " + this.getName() +
                ", be careful in here " + obsNumber +
                " " +
                this.getObstacle().getName() +
                " live.");

        System.out.print("You want to <F>ight or <R>un away ? : ");
        String selectCase = input.nextLine().toUpperCase();
        if (selectCase.equals("F") && combat(obsNumber)) {
            System.out.println(this.getName() + "win");
            return true;

        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("Dead");
            return false;
        }
        return true;
    }

    public int getRemainingObstacle() {
        return remainingObstacle;
    }

    public int randomStart() {
        int input = (int) Math.round(Math.random());
        return input;
    }

    public void setRemainingObstacle(int remainingObstacle) {
        this.remainingObstacle = remainingObstacle;
    }

    public boolean combat(int obsNumber) {
        for (int i = 1; i < obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getDefHealth());
            playerStats();
            obstacleStats(i);
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.print("<H>it or <R>un : ");
                String selectionCombat = input.nextLine().toUpperCase();
                if (selectionCombat.equals("H")) {
                    if (randomStart() == 0) {
                        System.out.println("You hit.");
                        this.getObstacle().setHealth(this.obstacle.getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();
                    } else {
                        if (this.getObstacle().getHealth() > 0) {
                            System.out.println();
                            System.out.println("Monster hits you");
                            int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                            if (obstacleDamage < 0) {
                                obstacleDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                            afterHit();
                        }
                    }

                } else {
                    return false;
                }
            }
        }
        if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
            System.out.println("You win and get " + this.getObstacle().getAward() + " coin :)");
            this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
            System.out.println("Your current coin : " + this.getPlayer().getMoney());
        } else {
            return false;
        }
        return true;
    }

    private void afterHit() {
        System.out.println("Your health : " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " health is : " + this.getObstacle().getHealth());
        System.out.println();
    }

    private void obstacleStats(int i) {
        System.out.println(i + " . " + this.getObstacle().getName() + " stats.");
        System.out.println("Health : " + this.getObstacle().getHealth());
        System.out.println("Damage : " + this.getObstacle().getDamage());
        System.out.println("Award : " + this.getObstacle().getAward());
    }

    private void playerStats() {
        System.out.println("Player Stats...");
        System.out.println("Health : " + this.getPlayer().getHealth());
        System.out.println("Weapon : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Damage : " + this.getPlayer().getTotalDamage());
        System.out.println("Armor : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Block : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Money : " + this.getPlayer().getMoney());
    }

    private int randomObstacleNumber() {
        Random random = new Random();
        if (this.getObstacle().getName().equals("Snake")) {
            return random.nextInt((5 - 1) + 1) + 1;
        }
        return random.nextInt((this.getMaxObstacle() - 1) + 1) + 1;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
}
