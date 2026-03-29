package cstjean.prog4.exo05;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Action actionA = new Action("Action A", 10.00);
        Action actionB = new Action("Action B", 15.00);
        Action actionC = new Action("Action C", 20.00);

        System.out.println("EXERCICE 5 \u2013 GESTIONNAIRE DE PORTEFEUILLE INTELLIGENT");
        System.out.println("2");
        System.out.printf("%s : %.2f$  %s : %.2f$  %s : %.2f$\n\n",
                actionA.getNom(), actionA.getPrix(),
                actionB.getNom(), actionB.getPrix(),
                actionC.getNom(), actionC.getPrix());

        List<Actif> actifs1 = new ArrayList<>();
        actifs1.add(new Actif(actionA, 5));

        List<Actif> actifs2 = new ArrayList<>();
        actifs2.add(new Actif(actionA, 5));

        List<Actif> actifs3 = new ArrayList<>();
        actifs3.add(new Actif(actionA, 5));
        actifs3.add(new Actif(actionB, 5));
        actifs3.add(new Actif(actionC, 5));

        List<Actif> actifs4 = new ArrayList<>();
        actifs4.add(new Actif(actionA, 5));
        actifs4.add(new Actif(actionB, 5));
        actifs4.add(new Actif(actionC, 5));

        List<Actif> actifs5 = new ArrayList<>();
        actifs5.add(new Actif(actionA, 5));
        actifs5.add(new Actif(actionB, 5));
        actifs5.add(new Actif(actionC, 15));

        List<Actif> actifs6 = new ArrayList<>();
        actifs6.add(new Actif(actionA, 5));
        actifs6.add(new Actif(actionB, 5));
        actifs6.add(new Actif(actionC, 5));

        Portefeuille p1 = new ProfilPeureux(200.00, new ActifsIterator(actifs1), "Portefeuille 1");
        afficherPortefeuille(p1, actifs1);

        Portefeuille p2 = new ProfilPeureux(200.00, new ActifsIterator(actifs2), "Portefeuille 2");
        afficherPortefeuille(p2, actifs2);

        Portefeuille p3 = new ProfilRelax(200.00, new ActifsIterator(actifs3), "Portefeuille 3");
        afficherPortefeuille(p3, actifs3);

        System.out.println("\n--------------------");
        System.out.println("Exemple 1");
        System.out.println("--------------------");
        actionA.setPrix(20.00);
        p1.verificationPortefeuille();
        actionA.setPrix(50.00);
        p1.verificationPortefeuille();

        actionA.setPrix(10.00);

        System.out.println("\n--------------------");
        System.out.println("Exemple 2");
        System.out.println("--------------------");
        actionA.setPrix(5.00);
        p2.verificationPortefeuille();

        actionA.setPrix(10.00);

        System.out.println("\n--------------------");
        System.out.println("Exemple 3");
        System.out.println("--------------------");
        p3.verificationPortefeuille();
        actionA.setPrix(5.00);
        actionA.setPrix(10.00);

        System.out.println("\nEXERCICE 5 \u2013 GESTIONNAIRE DE PORTEFEUILLE INTELLIGENT");
        System.out.println("4");
        Portefeuille p4 = new ProfilRelax(500.00, new ActifsIterator(actifs4), "Portefeuille 4");
        afficherPortefeuille(p4, actifs4);

        System.out.println("\n--------------------");
        System.out.println("Exemple 4");
        System.out.println("--------------------");
        System.out.println("\nChangement de profil pour le portefeuille «Portefeuille 4» : «Relax»\n");

        actionA.setPrix(5.00);
        p4.verificationPortefeuille();

        System.out.println("\nChangement de profil pour le portefeuille «Portefeuille 4» : «Peureux»\n");
        p4 = new ProfilPeureux(500.00, new ActifsIterator(actifs4), "Portefeuille 4");

        actionA.setPrix(6.00);
        p4.verificationPortefeuille();

        actionA.setPrix(5.00);
        p4.verificationPortefeuille();

        actionA.setPrix(10.00);

        System.out.println("\nEXERCICE 5 \u2013 GESTIONNAIRE DE PORTEFEUILLE INTELLIGENT");
        System.out.println("5");
        Portefeuille p5 = new ProfilDepend(500.00, new ActifsIterator(actifs5), "Portefeuille 5");
        afficherPortefeuille(p5, actifs5);

        Portefeuille p6 = new ProfilPeureux(300.00, new ActifsIterator(actifs6), "Portefeuille 6");
        afficherPortefeuille(p6, actifs6);

        System.out.println("\n--------------------");
        System.out.println("Exemple 5");
        System.out.println("--------------------");
        System.out.println("\nChangement de profil pour le portefeuille «Portefeuille 5» : «Ça dépend»\n");

        actionA.setPrix(5.00);
        p5.verificationPortefeuille();
        p6.verificationPortefeuille();

        actionC.setPrix(5.00);
        p5.verificationPortefeuille();
    }

    public static void afficherPortefeuille(Portefeuille p, List<Actif> listeActifs) {
        StringBuilder sb = new StringBuilder();
        sb.append(" ").append(p.name).append(" : ");

        boolean premierItem = true;
        for (ActifsIterator it = new ActifsIterator(listeActifs); it.hasNext(); ) {
            Actif actif = it.next();
            if (!premierItem) {
                sb.append(", ");
            }
            sb.append(actif.getAction().getNom()).append(" x ").append(actif.getQuantite());
            premierItem = false;
        }

        sb.append(String.format(". Objectif : %.2f$.", p.objectif).replace(',', '.'));
        System.out.println(sb.toString());
    }
}
