package bibliotheque.mvp.view;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.TypeLivre;
import bibliotheque.metier.TypeOuvrage;
import bibliotheque.mvp.presenter.OuvragePresenter;
import bibliotheque.utilitaires.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.choixElt;

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
        int choix = Utilitaire.choixElt(ouvrages);
        Ouvrage ouvrage = ouvrages.get(choix - 1);

        List<String> options = new ArrayList<>(Arrays.asList("Genre", "AgeMin", "Langue", "Titre", "Date parution", "Retour"));

        int ch = Utilitaire.choixListe(options);

        switch (ch) {
            case 1:
                ouvrage.setGenre(sc.next());
                break;

            case 2:
                try{
                    ouvrage.setAgeMin(sc.nextInt());
                }catch(Exception e){
                    System.out.println("Mauvais age entré");
                }
                break;
            case 3:
                ouvrage.setLangue(sc.next());
                break;
            case 4:
                ouvrage.setTitre(sc.next());
                break;
            case 5:
                ouvrage.setDateParution(Utilitaire.lecDate());
                break;
            default:
                break;
        }

        presenter.maj(ouvrage);
    }

    private void retirer() {
        int choix = Utilitaire.choixElt(ouvrages);
        Ouvrage auteur = ouvrages.get(choix - 1);
        presenter.removeOuvrage(auteur);
    }


    private void ajouter() {
        TypeOuvrage[] tto = TypeOuvrage.values();
        List<TypeOuvrage> lto = new ArrayList<>(Arrays.asList(tto));
        int choix = Utilitaire.choixListe(lto);
        Ouvrage o = null;

        List<OuvrageFactory> lof = new ArrayList<>(Arrays.asList(new LivreFactory(),new CDFactory(),new DVDFactory()));
        try {
            o = lof.get(choix-1).create();
        } catch (Exception e) {
            e.printStackTrace();
        }

        presenter.addOuvrage(o);
    }

    private void special() {
        int choix =  choixElt(ouvrages);
        Ouvrage lec = ouvrages.get(choix-1);

        do {
            List<String> options = new ArrayList<>(Arrays.asList("Lister exemplaires", "Lister exemplaires en location", "fin"));

            int ch = Utilitaire.choixListe(options);

            switch (ch) {
                case 1:
                    presenter.listerExemplaires(lec);
                    break;
                case 2:
                    presenter.listerExemplairesLocation(lec);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("choix invalide recommencez ");
            }
        } while (true);


    }


}

