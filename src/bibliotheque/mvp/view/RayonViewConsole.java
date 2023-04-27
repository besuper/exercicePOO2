package bibliotheque.mvp.view;

import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.Rayon;
import bibliotheque.mvp.presenter.RayonPresenter;
import bibliotheque.utilitaires.Utilitaire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.choixElt;

public class RayonViewConsole implements RayonViewInterface {
    private RayonPresenter presenter;
    private List<Rayon> rayons;
    private Scanner sc = new Scanner(System.in);

    public RayonViewConsole() {

    }

    @Override
    public void setPresenter(RayonPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setListDatas(List<Rayon> lecteurs) {
        this.rayons = lecteurs;
        Utilitaire.affListe(rayons);
        menu();
    }

    @Override
    public void affMsg(String msg) {
        System.out.println("information:" + msg);
    }

    public void menu() {
        List options = new ArrayList<>(Arrays.asList("ajouter", "retirer", "modifier", "special", "fin"));
        do {
            int ch = Utilitaire.choixListe(options);

            switch (ch) {
                case 1:
                    ajouter();
                    break;
                case 2:
                    retirer();
                    break;
                case 3:
                    modifier();
                    break;
                case 4:
                    special();
                    break;
                case 5:
                    System.exit(0);
            }
        } while (true);
    }

    private void modifier() {
        int choix = Utilitaire.choixElt(rayons);
        Rayon lecteur = rayons.get(choix - 1);

        System.out.println("Entrez le nouveau genre : ");
        lecteur.setGenre(sc.nextLine());

        presenter.maj(lecteur);
    }

    private void retirer() {
        int choix = Utilitaire.choixElt(rayons);
        Rayon lecteur = rayons.get(choix - 1);
        presenter.removeRayon(lecteur);
    }


    private void ajouter() {
        System.out.println("code ");
        String code = sc.next();

        System.out.println("genre ");
        String genre = sc.next();

        Rayon r = new Rayon(code, genre);
        presenter.addRayon(r);
    }

    private void special() {
        int choix =  choixElt(rayons);
        Rayon lec = rayons.get(choix-1);

        do {
            List<String> options = new ArrayList<>(Arrays.asList("Lister exemplaires", "fin"));

            int ch = Utilitaire.choixListe(options);

            switch (ch) {
                case 1:
                    presenter.listerExemplaires(lec);
                    break;
                case 2:
                    return;
                default:
                    System.out.println("choix invalide recommencez ");
            }
        } while (true);


    }


}

