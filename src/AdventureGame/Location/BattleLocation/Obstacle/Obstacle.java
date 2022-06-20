package AdventureGame.Location.BattleLocation.Obstacle;

import java.util.Random;

public class Obstacle {
    private Integer id;
    private String name;
    private Integer damage;
    private Integer health;
    private int award;
    private int defHealth;




    public Obstacle(Integer id, String name, Integer damage, Integer health, int award) {
        this.id = id;
        this.name=name;
        this.damage = damage;
        this.health = health;
        this.defHealth = health;
        this.award=award;
    }


    public Obstacle(int award) {
        this.award = award;
    }

    public int getAward() {
        return award;
    }

    public int getDefHealth() {
        return defHealth;
    }

    public void setDefHealth(int defHealth) {
        this.defHealth = defHealth;
    }

    public void setAward(int award) {
        this.award = award;
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
        Random random = new Random();
        if(this.getName().equals("Snake")){
            return random.nextInt(7-3) + 3;
        }
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        if(health<0){
            health=0;
        }
        this.health = health;
    }
}
