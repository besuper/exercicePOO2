package bibliotheque.mvp.presenter;

import bibliotheque.metier.*;
import bibliotheque.mvp.model.DAOAuteur;
import bibliotheque.mvp.model.DAOLecteur;
import bibliotheque.mvp.model.SpecialAuteur;
import bibliotheque.mvp.view.AuteurViewInterface;
import bibliotheque.mvp.view.LecteurViewInterface;

import java.util.List;

public class AuteurPresenter {
    private DAOAuteur model;
    private AuteurViewInterface view;

    public AuteurPresenter(DAOAuteur model, AuteurViewInterface view) {
        this.model = model;
        this.view = view;
        this.view.setPresenter(this);
    }

    public void start() {
        List<Auteur> auteurs = model.getAuteurs();
        view.setListDatas(auteurs);
    }

    public void addAuteur(Auteur lecteur) {
        Auteur lec = model.addAuteur(lecteur);

        if (lec != null) {
            view.affMsg("création de :" + lec);
        } else {
            view.affMsg("erreur de création");
        }

        List<Auteur> lecteurs = model.getAuteurs();
        //view.setListDatas(lecteurs);
    }


    public void removeAuteur(Auteur lecteur) {
        Auteur remove = model.removeAuteur(lecteur);

        if (remove != null) {
            view.affMsg("auteur effacé");
        } else {
            view.affMsg("auteur non effacé");
        }

        List<Auteur> lecteurs = model.getAuteurs();
        //view.setListDatas(lecteurs);
    }

    public void maj(Auteur lec) {
        Auteur update = model.maj(lec);

        if (update != null) {
            view.affMsg("Auteur modifié");

            List<Auteur> lecteurs = model.getAuteurs();
            //view.setListDatas(lecteurs);
        } else {
            view.affMsg("Erreur dans la modification de l'auteur");
        }
    }

    public List<Ouvrage> listerOuvrages(Auteur auteur) {
        return ((SpecialAuteur)model).listerOuvrages(auteur);
    }

    public List<Ouvrage> listerOuvragesType(Auteur auteur, TypeOuvrage to) {
        return ((SpecialAuteur)model).listerOuvrages(auteur, to);
    }

    public List<Livre> listerLivres(Auteur auteur, TypeLivre tl) {
        return ((SpecialAuteur)model).listerLivres(auteur, tl);
    }

    public List<Ouvrage> listerOuvragesGenre(Auteur auteur, String genre) {
        return ((SpecialAuteur)model).listerOuvrages(auteur, genre);
    }
}
