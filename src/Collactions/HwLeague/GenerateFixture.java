package Collactions.HwLeague;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GenerateFixture {
    public List<List<Match>> getFixtures(List<String> teamList) {
        int teamsCount = teamList.size();
        if (!isEven(teamsCount)) {
            teamList.add("Bay");
            teamsCount++;
        }
        Collections.shuffle(teamList);
        int totalRounds = teamsCount - 1;
        int matchesForRound = teamsCount / 2;
        List<List<Match>> rounds = new LinkedList<>();
        for (int i = 0; i < totalRounds; i++) {
            List<Match> matchList = new LinkedList<>();
            for (int j = 0; j < matchesForRound; j++) {
                int home = (j + i) % (teamsCount - 1);
                int deplacement = (teamsCount - 1 - j + i) % (teamsCount - 1);
                if (j == 0) {
                    deplacement = teamsCount - 1;
                }
                matchList.add(new Match(teamList.get(home), teamList.get(deplacement)));
            }
            rounds.add(matchList);
        }
        for (int i = 0; i < rounds.size(); i++) {
            if (!isEven(i)) {
                Match match = rounds.get(i).get(0);
                rounds.get(i).set(0, new Match(match.getDeplacement(), match.getHomeSide()));
            }
        }

        List<List<Match>> secondHalf = new LinkedList<>();
        for (List<Match> a : rounds) {
            List<Match> reverseRound = new LinkedList<>();
            for (Match match : a) {
                reverseRound.add(new Match(match.getDeplacement(), match.getHomeSide()));
            }


        }
        rounds.addAll(secondHalf);
        return rounds;
    }

    public void printAll(List<List<Match>> all) {
        int count = 1;
        for (List<Match> round : all) {
            System.out.println("-----" + count + ".Round" + "------");
            count++;
            for (Match match : round) {
                System.out.println(match.getHomeSide() + "-" + match.getDeplacement());
            }
        }
    }

    public boolean isEven(int teamsCount) {
        return teamsCount % 2 == 0;
    }

}
