package CommonDesignPatterns.Factory;

public class Client {
    public static void main(String[] args) {
        Computer mac=ComputerFactory.getComputer("IMac","1800");
        Computer windows=ComputerFactory.getComputer("Windows","2000");
        System.out.println(mac);
        System.out.println(windows);

    }
}
