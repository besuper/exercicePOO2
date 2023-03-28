package bibliotheque.mvp.presenter;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Ouvrage;
import bibliotheque.mvp.model.DAOOuvrage;
import bibliotheque.mvp.model.SpecialOuvrage;
import bibliotheque.mvp.view.OuvrageViewInterface;

import java.util.List;

public class OuvragePresenter {
    private DAOOuvrage model;
    private OuvrageViewInterface view;

    public OuvragePresenter(DAOOuvrage model, OuvrageViewInterface view) {
        this.model = model;
        this.view = view;
        this.view.setPresenter(this);
    }

    public void start() {
        List<Ouvrage> lecteurs = model.getOuvrages();
        view.setListDatas(lecteurs);
    }

    public void addOuvrage(Ouvrage lecteur) {
        Ouvrage lec = model.addOuvrage(lecteur);

        if (lec != null) {
            view.affMsg("création de :" + lec);
        } else {
            view.affMsg("erreur de création");
        }

        List<Ouvrage> lecteurs = model.getOuvrages();
        //view.setListDatas(lecteurs);
    }


    public void removeOuvrage(Ouvrage lecteur) {
        Ouvrage remove = model.removeOuvrage(lecteur);

        if (remove != null) {
            view.affMsg("ouvrage effacé");
        } else {
            view.affMsg("ouvrage non effacé");
        }

        List<Ouvrage> lecteurs = model.getOuvrages();
        //view.setListDatas(lecteurs);
    }

    public void maj(Ouvrage lec) {
        Ouvrage update = model.maj(lec);

        if (update != null) {
            view.affMsg("Ouvrage modifié");

            List<Ouvrage> lecteurs = model.getOuvrages();
            //view.setListDatas(lecteurs);
        } else {
            view.affMsg("Erreur dans la modification de l'ouvrage");
        }
    }

    public List<Exemplaire> listerExemplaires(Ouvrage ouvrage) {
        return ((SpecialOuvrage)model).listerExemplaires(ouvrage);
    }

    public List<Exemplaire> listerExemplairesLocation(Ouvrage ouvrage) {
        return ((SpecialOuvrage)model).listerExemplairesLocation(ouvrage);
    }
}
