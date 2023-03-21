package bibliotheque.mvp.view;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Lecteur;
import bibliotheque.mvp.presenter.AuteurPresenter;
import bibliotheque.mvp.presenter.LecteurPresenter;

import java.util.List;

public interface AuteurViewInterface {
    public void setPresenter(AuteurPresenter presenter);

    public void setListDatas(List<Auteur> auteurs);

    public void affMsg(String msg);


}
