package AdventureGame;

public class SafeHouse extends NormalLocation{
    public SafeHouse(Player player) {
        super(1,player,"Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are at safe house and recovered your health");
        return true;
    }
}
