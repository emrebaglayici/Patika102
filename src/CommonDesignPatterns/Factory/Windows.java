package CommonDesignPatterns.Factory;

public class Windows implements Computer{

    private String name;
    private String battery;

    public Windows(String name, String battery) {
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
        return "Windows{" +
                "name='" + name + '\'' +
                ", battery='" + battery + '\'' +
                '}';
    }
}
