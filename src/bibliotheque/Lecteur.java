package bibliotheque;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lecteur {

    private long numLecteur;
    private String nom;
    private String prenom;
    private String dateNaiss;
    private String mail;
    private String adresse;
    private String tel;

    private List<Location> locations = new ArrayList<>();

    public Lecteur(long numLecteur, String nom, String prenom, String dateNaiss, String mail, String adresse, String tel) {
        this.numLecteur = numLecteur;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaiss = dateNaiss;
        this.mail = mail;
        this.adresse = adresse;
        this.tel = tel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lecteur lecteur = (Lecteur) o;
        return numLecteur == lecteur.numLecteur;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numLecteur);
    }
}
