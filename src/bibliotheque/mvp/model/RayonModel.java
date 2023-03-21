package bibliotheque.mvp.model;

import bibliotheque.metier.Rayon;

import java.util.ArrayList;
import java.util.List;

public class RayonModel implements DAORayon {
    private List<Rayon> rayons = new ArrayList<>();

    @Override
    public Rayon addRayon(Rayon lec) {
        boolean present= rayons.contains(lec);
        if(!present){
            rayons.add(lec);
            return lec;
        }
        else return null;
    }

    public boolean maj(Rayon lec) {
        boolean present = rayons.contains(lec);

        if(!present) {
            return false;
        }

        Rayon oldLecteur = rayons.get(rayons.indexOf(lec));

        oldLecteur.setGenre(lec.getGenre());

        return true;
    }

    @Override
    public boolean removeRayon(Rayon lec) {
        return rayons.remove(lec);
    }

    @Override
    public List<Rayon> getRayons() {
        return new ArrayList<>(rayons);
    }
}

