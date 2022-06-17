package AdventureGame;

public class SafeHouse extends NormalLocation{
    public SafeHouse(Player player) {
        super(player,"Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are at safe house and recovered your health");
        this.getPlayer().setHealth(this.getPlayer().getDefHealth());
        return true;
    }
}
