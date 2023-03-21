package bibliotheque.mvp.presenter;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Lecteur;
import bibliotheque.mvp.model.DAOAuteur;
import bibliotheque.mvp.model.DAOLecteur;
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
        if (lec != null) view.affMsg("création de :" + lec);
        else view.affMsg("erreur de création");
        List<Auteur> lecteurs = model.getAuteurs();
        view.setListDatas(lecteurs);
    }


    public void removeAuteur(Auteur lecteur) {
        boolean ok = model.removeAuteur(lecteur);
        if (ok) view.affMsg("auteur effacé");
        else view.affMsg("auteur non effacé");
        List<Auteur> lecteurs = model.getAuteurs();
        view.setListDatas(lecteurs);
    }

    public void maj(Auteur lec) {
        if (model.maj(lec)) {
            view.affMsg("Auteur modifié");

            List<Auteur> lecteurs = model.getAuteurs();
            view.setListDatas(lecteurs);
        } else {
            view.affMsg("Erreur dans la modification de l'auteur");
        }
    }
}
