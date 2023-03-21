package bibliotheque.mvp.model;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Lecteur;

import java.util.List;

public interface DAOAuteur {
    Auteur addAuteur(Auteur lec);

    boolean removeAuteur(Auteur lec);

    List<Auteur> getAuteurs();

    boolean maj(Auteur lec);
}
