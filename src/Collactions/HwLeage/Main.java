package Collactions.HwLeage;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Fixture fixture=new Fixture();
        fixture.teams.add("Galatasaray");
        fixture.teams.add("Bursaspor");
        fixture.teams.add("Fenerbahçe");
        fixture.teams.add("Beşiktaş");
        fixture.teams.add("Başakşehir");
        fixture.teams.add("Trabzonspor");
        List<List<Match>> matches=fixture.roundStart();
        fixture.print(matches);

    }
}
