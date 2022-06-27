package Collactions.HwLeague;

public class Main {
    public static void main(String[] args) {
        Teams teams=new Teams();
        teams.teams.add("Galatasaray");
        teams.teams.add("Bursaspor");
        teams.teams.add("Fenerbahçe");
        teams.teams.add("Beşiktaş");
        teams.teams.add("Başakşehir");
        teams.teams.add("Trabzonspor");
        teams.printTeams();
        teams.roundStart();

    }
}
