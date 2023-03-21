package bibliotheque.mvp.model;

import bibliotheque.metier.Ouvrage;

import java.util.ArrayList;
import java.util.List;

public class OuvrageModel implements DAOOuvrage {
    private List<Ouvrage> ouvrages = new ArrayList<>();

    @Override
    public Ouvrage addOuvrage(Ouvrage lec) {
        boolean present= ouvrages.contains(lec);
        if(!present){
            ouvrages.add(lec);
            return lec;
        }
        else return null;
    }

    public boolean maj(Ouvrage lec) {
        boolean present = ouvrages.contains(lec);

        if(!present) {
            return false;
        }

        Ouvrage oldLecteur = ouvrages.get(ouvrages.indexOf(lec));

        oldLecteur = lec;

        return true;
    }

    @Override
    public boolean removeOuvrage(Ouvrage lec) {
        return ouvrages.remove(lec);
    }

    @Override
    public List<Ouvrage> getOuvrages() {
        return new ArrayList<>(ouvrages);
    }
}

