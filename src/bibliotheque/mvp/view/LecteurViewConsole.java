package bibliotheque.mvp.view;

import bibliotheque.metier.Lecteur;
import bibliotheque.mvp.presenter.LecteurPresenter;
import bibliotheque.utilitaires.Utilitaire;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LecteurViewConsole implements LecteurViewInterface {
    private LecteurPresenter presenter;
    private List<Lecteur> llec;
    private Scanner sc = new Scanner(System.in);

    public LecteurViewConsole() {

    }

    @Override
    public void setPresenter(LecteurPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setListDatas(List<Lecteur> lecteurs) {
        this.llec = lecteurs;
        Utilitaire.affListe(llec);
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
        int choix = Utilitaire.choixElt(llec);
        Lecteur lecteur = llec.get(choix - 1);

        List<String> options = new ArrayList<>(Arrays.asList("Nom", "Prenom", "Date naissance", "Mail", "Tel", "Adresse", "Retour"));

        int ch = Utilitaire.choixListe(options);

        switch (ch) {
            case 1 -> lecteur.setNom(sc.next());
            case 2 -> lecteur.setPrenom(sc.next());
            case 3 -> lecteur.setDn(Utilitaire.lecDate());
            case 4 -> lecteur.setMail(sc.next());
            case 5 -> lecteur.setTel(sc.next());
            case 6 -> lecteur.setAdresse(sc.nextLine());
        }

        presenter.maj(lecteur);
    }

    private void retirer() {
        int choix = Utilitaire.choixElt(llec);
        Lecteur lecteur = llec.get(choix - 1);
        presenter.removeLecteur(lecteur);
    }


    private void ajouter() {
        System.out.println("nom ");
        String nom = sc.nextLine();
        System.out.println("prénom ");
        String prenom = sc.nextLine();
        System.out.println("date de naissance");
        String[] jma = sc.nextLine().split(" ");
        int j = Integer.parseInt(jma[0]);
        int m = Integer.parseInt(jma[1]);
        int a = Integer.parseInt(jma[2]);
        LocalDate dn = LocalDate.of(a, m, j);
        System.out.println("adresse");
        String adr = sc.nextLine();
        System.out.println("mail");
        String mail = sc.nextLine();
        System.out.println("tel ");
        String tel = sc.nextLine();
        Lecteur lec = new Lecteur(0, nom, prenom, dn, adr, mail, tel);
        presenter.addLecteur(lec);
    }
}

