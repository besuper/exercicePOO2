package bibliotheque.mvp.model;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Ouvrage;

import java.util.ArrayList;
import java.util.List;

public class OuvrageModel implements DAOOuvrage, SpecialOuvrage {
    private List<Ouvrage> ouvrages = new ArrayList<>();

    @Override
    public Ouvrage addOuvrage(Ouvrage lec) {
        boolean present = ouvrages.contains(lec);
        if (!present) {
            ouvrages.add(lec);
            return lec;
        } else return null;
    }

    public Ouvrage maj(Ouvrage lec) {
        int index = ouvrages.indexOf(lec);

        if (index < 0) {
            return null;
        }

        return ouvrages.set(index, lec);
    }

    @Override
    public Ouvrage removeOuvrage(Ouvrage lec) {
        return ouvrages.remove(ouvrages.indexOf(lec));
    }

    @Override
    public List<Ouvrage> getOuvrages() {
        return new ArrayList<>(ouvrages);
    }

    @Override
    public List<Exemplaire> listerExemplaires(Ouvrage ouvrage) {
        return ouvrage.listerExemplaires();
    }

    @Override
    public List<Exemplaire> listerExemplairesLocation(Ouvrage ouvrage) {
        return ouvrage.listerExemplaires(true);
    }
}

