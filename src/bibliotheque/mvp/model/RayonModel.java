package bibliotheque.mvp.model;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Rayon;

import java.util.ArrayList;
import java.util.List;

public class RayonModel implements DAORayon, SpecialRayon {
    private List<Rayon> rayons = new ArrayList<>();

    @Override
    public Rayon addRayon(Rayon lec) {
        boolean present = rayons.contains(lec);

        if (!present) {
            rayons.add(lec);

            return lec;
        } else {
            return null;
        }
    }

    public Rayon maj(Rayon lec) {
        int index = rayons.indexOf(lec);

        if (index < 0) {
            return null;
        }

        return rayons.set(index, lec);
    }

    @Override
    public Rayon removeRayon(Rayon lec) {
        return rayons.remove(rayons.indexOf(lec));
    }

    @Override
    public List<Rayon> getRayons() {
        return new ArrayList<>(rayons);
    }

    @Override
    public List<Exemplaire> listerExemplaires(Rayon rayon) {
        return rayon.listerExemplaires();
    }
}

