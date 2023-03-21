package bibliotheque.mvp.view;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Ouvrage;
import bibliotheque.mvp.presenter.AuteurPresenter;
import bibliotheque.mvp.presenter.OuvragePresenter;

import java.util.List;

public interface OuvrageViewInterface {
    public void setPresenter(OuvragePresenter presenter);

    public void setListDatas(List<Ouvrage> auteurs);

    public void affMsg(String msg);


}
