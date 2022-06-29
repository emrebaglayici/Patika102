package Collactions.HwBackUp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Fixture {
    List<String> teams;

    public Fixture() {
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

        int min = 0, max = teams.size() - 1;
        int r = (int) Math.floor(Math.random() * (max - min + 1) + min);
        return r;

    }

    public List<List<Match>> roundStart() {
        if (!isEven()) {
            teams.add("Bay");
        }
        int roundNumber = teams.size() - 1;
        int mathPerRound = teams.size() / 2;
        Collections.shuffle(teams);
        List<List<Match>> rounds = new LinkedList<>();
        for (int i = 0; i < roundNumber; i++) {
            List<Match> matchList = new LinkedList<>();
            for (int j = 0; j < mathPerRound; j++) {
                String x, y;
                int tempX = (j + i) % (teams.size() - 1);
                int tempY = (teams.size() - 1 - j + i) % (teams.size() - 1);
                if(tempY==0)
                    tempY=teams.size()-1;

                matchList.add(new Match(teams.get(tempX), teams.get(tempY)));
            }
            rounds.add(matchList);

        }
        for (int j = 0; j < rounds.size(); j++) {
            if(!isEven()){
                Match match;
                match=rounds.get(j).get(0);
                rounds.get(j).set(0,new Match(match.getHomeSide(),
                        match.getDeplacement()));
            }
        }
        return rounds;

    }



    public void print(List<List<Match>> matches) {
        int count = 1;
        for (List<Match> round : matches) {
            System.out.println(count + ". round");
            count++;
            for (Match match : round) {
                System.out.println(match.getHomeSide() +
                        " vs " + match.getDeplacement());
            }
        }
    }

}
