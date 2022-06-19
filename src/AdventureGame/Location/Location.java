package AdventureGame.Location;

import AdventureGame.GameCharacter.Player;

import java.util.Scanner;

public abstract class Location {
    private Integer id;
    private Player player;
    private String name;
    public static final Scanner input=new Scanner(System.in);
    public Location(Player player, String name) {
        this.player = player;
        this.name = name;
    }
    public abstract boolean onLocation();
    public Player getPlayer() {
        return player;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
