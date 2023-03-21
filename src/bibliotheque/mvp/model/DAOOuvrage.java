package bibliotheque.mvp.model;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Ouvrage;

import java.util.List;

public interface DAOOuvrage {
    Ouvrage addOuvrage(Ouvrage lec);

    boolean removeOuvrage(Ouvrage lec);

    List<Ouvrage> getOuvrages();

    boolean maj(Ouvrage lec);
}
