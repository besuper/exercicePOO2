package bibliotheque.mvp.model;

import bibliotheque.metier.Lecteur;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LecteurModel implements DAOLecteur {
    private int numcli =0;
    private List<Lecteur> lecteurs = new ArrayList<>();

    @Override
    public Lecteur addLecteur(Lecteur lec) {
        boolean present= lecteurs.contains(lec);
        if(!present){
            numcli++;
            lec.setNumlecteur(numcli);
            lecteurs.add(lec);
            return lec;
        }
        else return null;
    }

    public boolean maj(Lecteur lec) {
        boolean present = lecteurs.contains(lec);

        if(!present) {
            return false;
        }

        Lecteur oldLecteur = lecteurs.get(lecteurs.indexOf(lec));

        if (oldLecteur.getNumlecteur() != lec.getNumlecteur()) {
            return false;
        }

        oldLecteur.setNom(lec.getNom());
        oldLecteur.setPrenom(lec.getPrenom());
        oldLecteur.setAdresse(lec.getAdresse());
        oldLecteur.setMail(lec.getMail());
        oldLecteur.setTel(lec.getTel());
        oldLecteur.setDn(lec.getDn());

        return true;
    }

    @Override
    public boolean removeLecteur(Lecteur lec) {
        return lecteurs.remove(lec);
    }

    @Override
    public List<Lecteur> getLecteurs() {
        return new ArrayList<>(lecteurs);
    }
}

