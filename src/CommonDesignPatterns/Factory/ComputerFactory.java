package CommonDesignPatterns.Factory;

public class ComputerFactory {
    public static Computer getComputer(String name,String battery){
        Computer computer;
        if (name.equals("IMac")){
            computer=new Mac(name,battery);
        } else if (name.equals("Windows")) {
            computer=new Windows(name,battery);
        }else {
            throw new RuntimeException("Invalid Type");
        }
        return computer;
    }
}
