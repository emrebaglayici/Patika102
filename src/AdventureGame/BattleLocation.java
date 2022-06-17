package AdventureGame;

import java.util.Random;

public abstract class BattleLocation extends Location{
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    public BattleLocation(Player player, String name,Obstacle obstacle,String award,int maxObstacle) {
        super(player, name);
        this.obstacle=obstacle;
        this.award=award;
        this.maxObstacle=maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber=this.randomObstacleNumber();
        System.out.println("you are now here : "+this.getName());
        System.out.println("Be careful. In here "+obsNumber+" "+this.getObstacle().getName()+" lives");
        System.out.print("<F>ight or <R>un : ");
        String selectCase=input.nextLine().toUpperCase();
        if(selectCase.equals("F") && combat(obsNumber)){
             System.out.println(this.getName()+ "win");
             return true;

        }
        if(this.getPlayer().getHealth()<=0){
            System.out.println("Dead");
            return false;
        }
        return true;
    }
    public boolean combat(int obsNumber){
        for (int i = 1; i <obsNumber ; i++) {
            this.getObstacle().setHealth(this.getObstacle().getDefHealth());
            playerStats();
            obstacleStats(i);
            while (this.getPlayer().getHealth()>0 && this.getObstacle().getHealth()>0){
                System.out.print("<H>it or <R>un : ");
                String selectionCombat=input.nextLine().toUpperCase();
                if(selectionCombat.equals("H")){
                    System.out.println("You hit.");
                    this.getObstacle().setHealth(this.obstacle.getHealth()-this.getPlayer().getTotalDamage());
                    afterHit();
                    if(this.getObstacle().getHealth()>0){
                        System.out.println();
                        System.out.println("Monster hits you");
                        int obstacleDamage=this.getObstacle().getDamage()-this.getPlayer().getInventory().getArmor().getBlock();
                        if(obstacleDamage<0){
                            obstacleDamage=0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth()-obstacleDamage);
                        afterHit();
                    }

                }else{
                    return false;
                }
            }
            if(this.getObstacle().getHealth()<this.getPlayer().getHealth()){
                System.out.println("win");
                System.out.println(this.getObstacle().getAward()+ " earn money");
                this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getAward());
                System.out.println("Current money : "+this.getPlayer().getMoney());
            }else{
                return false;
            }
        }
        return false;
    }

    private void afterHit() {
        System.out.println("Your health : "+this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName()+" health is : "+this.getObstacle().getHealth());
        System.out.println();
    }

    private void obstacleStats(int i) {
        System.out.println(i+" . "+this.getObstacle().getName()+" stats.");
        System.out.println("Health : "+this.getObstacle().getHealth());
        System.out.println("Damage : "+this.getObstacle().getDamage());
        System.out.println("Award : "+this.getObstacle().getAward());
    }

    private void playerStats() {
        System.out.println("Player Stats...");
        System.out.println("Health : "+this.getPlayer().getHealth());
        System.out.println("Weapon : "+this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Damage : "+this.getPlayer().getTotalDamage());
        System.out.println("Armor : "+this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Block : "+this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Money : "+this.getPlayer().getMoney());
    }

    private int randomObstacleNumber(){
        Random random=new Random();
        return random.nextInt(this.getMaxObstacle()+1);
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
