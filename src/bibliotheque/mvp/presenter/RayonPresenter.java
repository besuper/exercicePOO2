package bibliotheque.mvp.presenter;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Rayon;
import bibliotheque.mvp.model.DAOAuteur;
import bibliotheque.mvp.model.DAORayon;
import bibliotheque.mvp.view.AuteurViewInterface;
import bibliotheque.mvp.view.RayonViewInterface;

import java.util.List;

public class RayonPresenter {
    private DAORayon model;
    private RayonViewInterface view;

    public RayonPresenter(DAORayon model, RayonViewInterface view) {
        this.model = model;
        this.view = view;
        this.view.setPresenter(this);
    }

    public void start() {
        List<Rayon> auteurs = model.getRayons();
        view.setListDatas(auteurs);
    }

    public void addRayon(Rayon lecteur) {
        Rayon lec = model.addRayon(lecteur);
        if(lec!=null) view.affMsg("création de :"+lec);
        else view.affMsg("erreur de création");
        List<Rayon> lecteurs = model.getRayons();
        view.setListDatas(lecteurs);
    }


    public void removeRayon(Rayon lecteur) {
        boolean ok = model.removeRayon(lecteur);
        if(ok) view.affMsg("rayon effacé");
        else view.affMsg("rayon non effacé");
        List<Rayon> lecteurs = model.getRayons();
        view.setListDatas(lecteurs);
    }

    public void maj(Rayon lec) {
        if(model.maj(lec)) {
            view.affMsg("Rayon modifié");

            List<Rayon> lecteurs = model.getRayons();
            view.setListDatas(lecteurs);
        }else {
            view.affMsg("Erreur dans la modification du rayon");
        }
    }
}
