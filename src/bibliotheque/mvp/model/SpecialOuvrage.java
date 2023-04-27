package bibliotheque.mvp.model;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Ouvrage;

import java.util.List;

public interface SpecialOuvrage {

    List<Exemplaire> listerExemplaires(Ouvrage ouvrage);
    List<Exemplaire> listerExemplairesLocation(Ouvrage ouvrage);
}
