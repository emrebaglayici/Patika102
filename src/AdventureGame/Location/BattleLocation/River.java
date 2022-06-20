package AdventureGame.Location.BattleLocation;

import AdventureGame.Location.BattleLocation.Obstacle.Bear;
import AdventureGame.GameCharacter.Player;

public class River extends BattleLocation {
    public River(Player player) {
        super(player, "River", new Bear(), "Water",3);
    }
}
