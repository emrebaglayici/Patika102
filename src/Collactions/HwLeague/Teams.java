package Collactions.HwLeague;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Teams {

    List<String> teams;

    public Teams() {
        this.teams = new ArrayList();
    }

    public void printTeams() {
        for (String str : this.teams) {
            System.out.println(str);
        }
    }

    public List<String> getTeams() {
        return teams;
    }

    public boolean isEven() {
        return this.teams.size() % 2 == 0;
    }

    public ArrayList<Integer> generateRandom() {
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            int min = 0, max = teams.size();
            int r = (int) Math.floor(Math.random() * (max - min + 1) + min);
            randomNumbers.add(r);
        }
        return randomNumbers;
    }

    public int generateInts() {

        int min = 0, max = teams.size()-1;
        int r = (int) Math.floor(Math.random() * (max - min + 1) + min);
        return r;

    }

    public void roundStart() {
        if (isEven()) {
            //çift takım girilme durumu
            for (int i = 0; i <=this.teams.size()-1; i++) {
                String x,y;
                x=this.teams.get(generateInts());
                y=this.teams.get(generateInts());
                if(x.equals(y)){
                    y=this.teams.get(generateInts());
                    System.out.println(x + " vs " + y);
                }
                else
                    System.out.println(x + " vs " + y);
            }


//            if(this.teams.size()<)

        } else {
            //tek takım girilme durumu
        }
    }
}
