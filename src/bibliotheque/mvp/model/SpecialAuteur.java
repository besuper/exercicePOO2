package bibliotheque.mvp.model;

import bibliotheque.metier.*;

import java.util.List;

public interface SpecialAuteur {

    List<Ouvrage> listerOuvrages(Auteur auteur);

    List<Ouvrage> listerOuvrages(Auteur auteur, TypeOuvrage to);

    List<Livre> listerLivres(Auteur auteur, TypeLivre tl);

    List<Ouvrage> listerOuvrages(Auteur auteur, String genre);

}
