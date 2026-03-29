package cstjean.prog4.exo05;

import java.text.NumberFormat;

public abstract class Portefeuille {
    protected final double objectif;
    protected final ActifsIterator actifs;
    protected final double valeurInit;
    protected final String name;
    protected final String profil;

    public Portefeuille(double objectif, ActifsIterator actifs, String name, String profil) {
        this.objectif = objectif;
        this.actifs = actifs;
        this.name = name;
        this.profil = profil;
        valeurInit = getValeur();
    }

    public final void verificationPortefeuille() {
        System.out.println("###############");
        System.out.printf("Évaluation du portefeuille «%s» avec profil «%s»\n", name, profil);
        System.out.println("Résultat :");
        if (verifyObjectif()) {
            sellAction();
        }
        System.out.println("###############");
    }

    public boolean verifyObjectif() {
        if (objectif <= getValeur()) {
            System.out.println("Objectif atteint");
            return true;
        }
        System.out.println("Rien effectué");
        return false;
    }

    public void sellAction() {
        NumberFormat defaultFormatter = NumberFormat.getCurrencyInstance();
        System.out.printf("Vente d'action du portefeuille «%s»\n", name);
        System.out.println("Valeur initiale : " + defaultFormatter.format(valeurInit));
        double valeurActuel = getValeur();
        System.out.println("Valeur actuel : " + defaultFormatter.format(valeurActuel));
        System.out.println("Objectif : " + defaultFormatter.format(objectif));
        System.out.println("Profit : " + defaultFormatter.format(valeurActuel - valeurInit));
    }

    public double getValeur() {
        double value = 0.0;
        actifs.reset();
        ActifsIterator it = actifs;
        while (it.hasNext()) {
            Actif actif = it.next();
            value += actif.getAction().getPrix() * actif.getQuantite();
        }
        return value;
    }

    public boolean isActionDown() {
        actifs.reset();
        for (ActifsIterator it = actifs; it.hasNext(); ) {
            Actif actif = it.next();
            if (actif.getAction().getIsDown()) {
                return true;
            }
        }
        return false;
    }
}
