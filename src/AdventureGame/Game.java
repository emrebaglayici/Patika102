package AdventureGame;

import AdventureGame.GameCharacter.Player;
import AdventureGame.Location.BattleLocation.Cave;
import AdventureGame.Location.BattleLocation.Forest;
import AdventureGame.Location.BattleLocation.Mine;
import AdventureGame.Location.BattleLocation.River;
import AdventureGame.Location.Location;
import AdventureGame.Location.NormalLocation.SafeHouse;
import AdventureGame.Location.NormalLocation.ToolStore.ToolStore;

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
            System.out.println("Locations... " +
                    "\n0- Exit " +
                    "\n1- Safe House" +
                    "\n2- Tool Store " +
                    "\n3- Cave " +
                    "\n4- Forest " +
                    "\n5- River " +
                    "\n6- Mine"+
                    "\n");
            System.out.print("Please select a location = ");
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
                case 6:
                    location=new Mine(player);
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
