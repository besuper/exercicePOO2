package bibliotheque.mvp;

import bibliotheque.mvp.model.*;
import bibliotheque.mvp.presenter.AuteurPresenter;
import bibliotheque.mvp.presenter.LecteurPresenter;
import bibliotheque.mvp.presenter.OuvragePresenter;
import bibliotheque.mvp.presenter.RayonPresenter;
import bibliotheque.mvp.view.*;
import bibliotheque.utilitaires.Utilitaire;

import java.util.Arrays;
import java.util.List;

public class GestBiblio {

    private DAOLecteur lm;
    private LecteurViewInterface lv;
    private LecteurPresenter lp;


    private DAOAuteur am;
    private AuteurViewInterface av;
    private AuteurPresenter ap;


    private DAOOuvrage om;
    private OuvrageViewConsole ov;
    private OuvragePresenter op;


    private DAORayon rm;
    private RayonViewConsole rv;
    private RayonPresenter rp;

    public void gestion(){
        lm = new LecteurModel();
        lv = new LecteurViewConsole();
        lp = new LecteurPresenter(lm, lv);//création et injection de dépendance

        am = new AuteurModel();
        av = new AuteurViewConsole();
        ap = new AuteurPresenter(am, av);

        om = new OuvrageModel();
        ov = new OuvrageViewConsole();
        op = new OuvragePresenter(om, ov);

        rm = new RayonModel();
        rv = new RayonViewConsole();
        rp = new RayonPresenter(rm, rv);

        List<String> loptions = Arrays.asList("lecteurs", "auteurs", "ouvrages", "rayons","fin");
        do {
            int ch = Utilitaire.choixListe(loptions);
            switch (ch){
                case 1: lp.start();
                    break;
                case 2: ap.start();
                    break;
                case 3: op.start();
                    break;
                case 4: rp.start();
                    break;
                case 5 : System.exit(0);
            }
        }while(true);
    }
    public static void main(String[] args) {
        GestBiblio gb = new GestBiblio();
        gb.gestion();
    }
}
