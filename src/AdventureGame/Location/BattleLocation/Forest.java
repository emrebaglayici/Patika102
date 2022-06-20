package AdventureGame.Location.BattleLocation;

import AdventureGame.GameCharacter.Player;
import AdventureGame.Location.BattleLocation.Obstacle.Vampire;

public class Forest extends BattleLocation {

    public Forest(Player player) {
        super(player, "Forest", new Vampire(), "Firewood",3);
    }
}
