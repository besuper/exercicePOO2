package bibliotheque.mvp.model;

import bibliotheque.metier.*;

import java.util.ArrayList;
import java.util.List;

public class AuteurModel implements DAOAuteur, SpecialAuteur {
    private List<Auteur> auteurs = new ArrayList<>();

    @Override
    public Auteur addAuteur(Auteur lec) {
        boolean present = auteurs.contains(lec);

        if (!present) {
            auteurs.add(lec);

            return lec;
        } else {
            return null;
        }
    }

    public Auteur maj(Auteur lec) {
        int index = auteurs.indexOf(lec);

        if (index < 0) {
            return null;
        }

        return auteurs.set(index, lec);
    }

    @Override
    public Auteur removeAuteur(Auteur lec) {
        return auteurs.remove(auteurs.indexOf(lec));
    }

    @Override
    public List<Auteur> getAuteurs() {
        return new ArrayList<>(auteurs);
    }

    @Override
    public List<Ouvrage> listerOuvrages(Auteur auteur) {
        return auteur.listerOuvrages();
    }

    @Override
    public List<Ouvrage> listerOuvrages(Auteur auteur, TypeOuvrage to) {
        return auteur.listerOuvrages(to);
    }

    @Override
    public List<Livre> listerLivres(Auteur auteur, TypeLivre tl) {
        return auteur.listerLivres(tl);
    }

    @Override
    public List<Ouvrage> listerOuvrages(Auteur auteur, String genre) {
        return auteur.listerOuvrages(genre);
    }
}

