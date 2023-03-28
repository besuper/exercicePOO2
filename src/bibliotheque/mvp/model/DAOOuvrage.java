package bibliotheque.mvp.model;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Ouvrage;

import java.util.List;

public interface DAOOuvrage {
    Ouvrage addOuvrage(Ouvrage lec);

    Ouvrage removeOuvrage(Ouvrage lec);

    List<Ouvrage> getOuvrages();

    Ouvrage maj(Ouvrage lec);
}
