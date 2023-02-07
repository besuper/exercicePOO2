package bibliotheque;

import java.util.Objects;

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

    public String getDateLoc() {
        return dateLoc;
    }

    public void setDateLoc(String dateLoc) {
        this.dateLoc = dateLoc;
    }

    public String getDateRestitution() {
        return dateRestitution;
    }

    public void setDateRestitution(String dateRestitution) {
        this.dateRestitution = dateRestitution;
    }

    public double getAmende() {
        return amende;
    }

    public void setAmende(double amende) {
        this.amende = amende;
    }

    public Lecteur getLecteur() {
        return lecteur;
    }

    public void setLecteur(Lecteur lecteur) {
        this.lecteur = lecteur;
    }

    public Exemplaire getExemplaire() {
        return exemplaire;
    }

    public void setExemplaire(Exemplaire exemplaire) {
        this.exemplaire = exemplaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(dateLoc, location.dateLoc) && Objects.equals(lecteur, location.lecteur) && Objects.equals(exemplaire, location.exemplaire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateLoc, lecteur, exemplaire);
    }

    @Override
    public String toString() {
        return "Location{" +
                "dateLoc='" + dateLoc + '\'' +
                ", dateRestitution='" + dateRestitution + '\'' +
                ", amende=" + amende +
                ", lecteur=" + lecteur +
                ", exemplaire=" + exemplaire +
                '}';
    }
}
