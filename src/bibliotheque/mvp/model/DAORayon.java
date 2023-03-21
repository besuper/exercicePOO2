package bibliotheque.mvp.model;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Rayon;

import java.util.List;

public interface DAORayon {
    Rayon addRayon(Rayon lec);

    boolean removeRayon(Rayon lec);

    List<Rayon> getRayons();

    boolean maj(Rayon lec);
}
