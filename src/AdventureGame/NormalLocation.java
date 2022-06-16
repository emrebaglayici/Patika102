package AdventureGame;

public abstract class NormalLocation extends Location {
    public NormalLocation(Integer id,Player player, String name) {
        super(id,player, name);
    }

    @Override
    public boolean onLocation() {
        return true;
    }

}
