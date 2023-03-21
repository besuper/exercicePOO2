package bibliotheque.mvp.view;

import bibliotheque.metier.Auteur;
import bibliotheque.mvp.presenter.AuteurPresenter;
import bibliotheque.utilitaires.Utilitaire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AuteurViewConsole implements AuteurViewInterface {
    private AuteurPresenter presenter;
    private List<Auteur> auteurs;
    private Scanner sc = new Scanner(System.in);

    public AuteurViewConsole() {

    }

    @Override
    public void setPresenter(AuteurPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setListDatas(List<Auteur> auteurs) {
        this.auteurs = auteurs;
        Utilitaire.affListe(this.auteurs);
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
        int choix = Utilitaire.choixElt(auteurs);
        Auteur lecteur = auteurs.get(choix - 1);

        List<String> options = new ArrayList<>(Arrays.asList("Nom", "Prenom", "Nationalité", "Retour"));

        int ch = Utilitaire.choixListe(options);

        switch (ch) {
            case 1 -> lecteur.setNom(sc.next());
            case 2 -> lecteur.setPrenom(sc.next());
            case 3 -> lecteur.setNationalite(sc.next());
        }

        presenter.maj(lecteur);
    }

    private void retirer() {
        int choix = Utilitaire.choixElt(auteurs);
        Auteur auteur = auteurs.get(choix - 1);
        presenter.removeAuteur(auteur);
    }


    private void ajouter() {
        System.out.println("nom ");
        String nom = sc.nextLine();
        System.out.println("prénom ");
        String prenom = sc.nextLine();
        System.out.println("nationalité");
        String nat = sc.nextLine();
        Auteur a = new Auteur(nom, prenom, nat);
        presenter.addAuteur(a);
    }
}

