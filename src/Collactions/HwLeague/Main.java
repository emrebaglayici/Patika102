package Collactions.HwLeague;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> teamList=new ArrayList<>();
        teamList.add("Galatasaray");
        teamList.add("Bursaspor");
        teamList.add("Fenerbahçe");
        teamList.add("Beşiktaş");
        teamList.add("Başakşehir");
        teamList.add("Trabzonspor");

        GenerateFixture generateFixture=new GenerateFixture();
        List<List<Match>> matches=generateFixture.getFixtures(teamList);
        generateFixture.printAll(matches);

    }
}
