package bibliotheque.mvp.view;

import bibliotheque.metier.Ouvrage;
import bibliotheque.mvp.presenter.OuvragePresenter;
import bibliotheque.utilitaires.Utilitaire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class OuvrageViewConsole implements OuvrageViewInterface {
    private OuvragePresenter presenter;
    private List<Ouvrage> ouvrages;
    private Scanner sc = new Scanner(System.in);

    public OuvrageViewConsole() {

    }

    @Override
    public void setPresenter(OuvragePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setListDatas(List<Ouvrage> auteurs) {
        this.ouvrages = auteurs;
        Utilitaire.affListe(this.ouvrages);
        menu();
    }

    @Override
    public void affMsg(String msg) {
        System.out.println("information:" + msg);
    }

    public void menu() {
        List options = new ArrayList<>(Arrays.asList("ajouter", "retirer", "modifier", "fin"));
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
                    System.exit(0);
            }
        } while (true);
    }

    private void modifier() {
        int choix = Utilitaire.choixElt(ouvrages);
        Ouvrage ouvrage = ouvrages.get(choix - 1);

        List<String> options = new ArrayList<>(Arrays.asList("Genre", "AgeMin", "Langue", "Titre", "Date parution", "Retour"));

        int ch = Utilitaire.choixListe(options);

        switch (ch) {
            case 1 -> ouvrage.setGenre(sc.next());
            case 2 -> ouvrage.setAgeMin(sc.nextInt());
            case 3 -> ouvrage.setLangue(sc.next());
            case 4 -> ouvrage.setTitre(sc.next());
            case 5 -> ouvrage.setDateParution(Utilitaire.lecDate());
        }

        presenter.maj(ouvrage);
    }

    private void retirer() {
        int choix = Utilitaire.choixElt(ouvrages);
        Ouvrage auteur = ouvrages.get(choix - 1);
        presenter.removeOuvrage(auteur);
    }


    private void ajouter() {

    }
}

