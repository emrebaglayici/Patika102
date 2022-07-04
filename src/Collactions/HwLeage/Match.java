package Collactions.HwLeage;

public class Match {
    private String homeSide;
    private String deplacement;

    public Match(String homeSide, String deplacement) {
        this.homeSide = homeSide;
        this.deplacement = deplacement;
    }
    public String getHomeSide() {
        return homeSide;
    }
    public String getDeplacement() {
        return deplacement;
    }
}
