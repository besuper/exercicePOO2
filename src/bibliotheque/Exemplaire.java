package bibliotheque;

import java.util.ArrayList;
import java.util.List;

public class Exemplaire {

    private Long matricule;
    private String descriptionEtat;
    private Rayon rayon;
    private Ouvrage ouvrage;

    private List<Location> locations = new ArrayList<>();

    public Exemplaire(long matricule, String descriptionEtat, Rayon rayon, Ouvrage ouvrage) {
        this.matricule = matricule;
        this.descriptionEtat = descriptionEtat;
        this.rayon = rayon;
        this.ouvrage = ouvrage;
    }
}
