package bibliotheque.mvp.model;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Lecteur;

import java.util.List;

public interface DAOAuteur {
    Auteur addAuteur(Auteur lec);

    Auteur removeAuteur(Auteur lec);

    List<Auteur> getAuteurs();

    Auteur maj(Auteur lec);
}
