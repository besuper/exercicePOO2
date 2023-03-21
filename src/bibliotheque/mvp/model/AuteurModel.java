package bibliotheque.mvp.model;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Lecteur;

import java.util.ArrayList;
import java.util.List;

public class AuteurModel implements DAOAuteur {
    private List<Auteur> auteurs = new ArrayList<>();

    @Override
    public Auteur addAuteur(Auteur lec) {
        boolean present= auteurs.contains(lec);
        if(!present){
            auteurs.add(lec);
            return lec;
        }
        else return null;
    }

    public boolean maj(Auteur lec) {
        boolean present = auteurs.contains(lec);

        if(!present) {
            return false;
        }

        Auteur oldLecteur = auteurs.get(auteurs.indexOf(lec));

        oldLecteur.setNom(lec.getNom());
        oldLecteur.setPrenom(lec.getPrenom());
        oldLecteur.setNationalite(lec.getNationalite());

        return true;
    }

    @Override
    public boolean removeAuteur(Auteur lec) {
        return auteurs.remove(lec);
    }

    @Override
    public List<Auteur> getAuteurs() {
        return new ArrayList<>(auteurs);
    }
}

