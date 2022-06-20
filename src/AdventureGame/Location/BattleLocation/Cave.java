package AdventureGame.Location.BattleLocation;

import AdventureGame.GameCharacter.Player;
import AdventureGame.Location.BattleLocation.Obstacle.Zombie;

public class Cave extends BattleLocation{
    public Cave(Player player) {
        super(player, "Cave",new Zombie(),"Food",3);
    }
}
