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
            System.out.println("0- Exit");
            System.out.println("1- Safe House");
            System.out.println("2- Tool Store");
            System.out.println("3- Cave");
            System.out.println("4- Forest");
            System.out.println("5- River");
            System.out.println("Please select a location");
            int selection=input.nextInt();
            switch (selection){
                case 0:
                    location=null;
                    break;
                case 1:
                    location=new SafeHouse(player);
                    break;
                case 2:
                    location=new ToolStore(player);
                    break;
                case 3:
                    location=new Cave(player);
                    break;
                case 4:
                    location=new Forest(player);
                    break;
                case 5:
                    location=new River(player);
                    break;
                default:
                    System.out.println("Please type valid location !!");
            }
            if(location==null){
                System.out.println("game over see you");
                break;
            }
            if(!location.onLocation()){
                System.out.println("Game Over !");
                break;
            }
        }
    }
}
