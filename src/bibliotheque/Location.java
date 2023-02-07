package bibliotheque;

public class Location {

    private String dateLoc;
    private String dateRestitution;
    private double amende;
    private Lecteur lecteur;
    private Exemplaire exemplaire;

    public Location(String dateLoc, String dateRestitution, double amende, Lecteur lecteur, Exemplaire exemplaire) {
        this.dateLoc = dateLoc;
        this.dateRestitution = dateRestitution;
        this.amende = amende;
        this.lecteur = lecteur;
        this.exemplaire = exemplaire;
    }
}
