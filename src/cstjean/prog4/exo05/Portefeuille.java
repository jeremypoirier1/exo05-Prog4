package cstjean.prog4.exo05;

import java.util.List;

public abstract class Portefeuille {
    private final double objectif;
    private final List<Action> actifs;
    private final double valeurInit;
    private final String name;

    public Portefeuille(double objectif,  actifs, String name) {
        this.objectif = objectif;
        this.actifs = actifs;
        this.name = name;
        valeurInit = getValeur();
    }

    public final void verificationPortefeuille() {

    }

    public void verifyObjectif() {
        if (objectif >= actifs.getValeur()) {
            System.out.println("Objectif atteint");
            sellAction();
            return;
        }
        System.out.println("Objectif non atteint");
    }

    public void sellAction() {
        System.out.printf("Vente d'action du portefeuille «%s»\n", name);
        System.out.println("Valeur initiale : " + valeurInit);
        double valeurActuel = actifs.getValeur();
        System.out.println("Valeur actuel : " + valeurActuel);
        System.out.println("Profit : " + (valeurActuel - valeurInit));
    }
}
