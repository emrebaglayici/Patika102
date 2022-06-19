package AdventureGame.Location.BattleLocation;

import AdventureGame.GameCharacter.Player;
import AdventureGame.Location.Award.Weapon;
import AdventureGame.Location.BattleLocation.Obstacle.Snake;

public class Mine extends BattleLocation {


    public Mine(Player player) {
        super(player, "Mine", new Snake(),new Weapon());
    }
}
