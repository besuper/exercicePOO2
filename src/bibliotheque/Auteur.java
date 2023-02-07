package bibliotheque;

import java.util.ArrayList;
import java.util.List;

public class Auteur {

    private String nom;
    private String prenom;
    private String nationalite;

    private List<Ouvrage> ouvrages = new ArrayList<>();

    public Auteur(String nom, String prenom, String nationalite) {
        this.nom = nom;
        this.prenom = prenom;
        this.nationalite = nationalite;
    }
}
