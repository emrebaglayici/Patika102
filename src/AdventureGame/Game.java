package AdventureGame;

import java.util.Scanner;

public class Game {
    private final Scanner input=new Scanner(System.in);
    private Player player;

    public void start(){
        System.out.println("Welcome to the game");
        System.out.print("Please enter a nickname :");
        String playerName=input.nextLine();
        Player player=new Player(playerName);
        System.out.println(player.getName()+" welcome !");
        player.selectChar();
        Location location=null;
        while (true){
            player.printInfo();
            System.out.println("Locations...");
            Location[] locations={new SafeHouse(player),new ToolStore(player)};
            for(Location loc:locations){
                System.out.println("Id : "+loc.getId()+
                        " "+loc.getName());
            }
            System.out.println("Please select a location");
            int selection=input.nextInt();
            if (selection == 2) {
                location = new ToolStore(player);
            } else {
                location = new SafeHouse(player);
            }
            if(!location.onLocation()){
                System.out.println("Game Over !");
                break;
            }
        }
    }
}
