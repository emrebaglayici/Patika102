package CommonDesignPatterns.Factory;

public class Mac implements Computer {
    private String name;
    private String battery;

    public Mac(String name, String battery) {
        this.name = name;
        this.battery = battery;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getBatteryCapacity() {
        return battery;
    }

    @Override
    public String toString() {
        return "Mac{" +
                "name='" + name + '\'' +
                ", battery='" + battery + '\'' +
                '}';
    }
}
