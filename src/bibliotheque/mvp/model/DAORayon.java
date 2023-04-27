package bibliotheque.mvp.model;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Rayon;

import java.util.List;

public interface DAORayon {
    Rayon addRayon(Rayon lec);

    Rayon removeRayon(Rayon lec);

    List<Rayon> getRayons();

    Rayon maj(Rayon lec);
}
