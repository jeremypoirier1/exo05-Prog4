package cstjean.prog4.exo05;

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
        if (objectif >= getValeur()) {
            System.out.println("Objectif atteint");
            sellAction();
            return true;
        }
        System.out.println("Objectif non atteint");
        return false;
    }

    public void sellAction() {
        System.out.printf("Vente d'action du portefeuille «%s»\n", name);
        System.out.println("Valeur initiale : " + valeurInit);
        double valeurActuel = getValeur();
        System.out.println("Valeur actuel : " + valeurActuel);
        System.out.println("Profit : " + (valeurActuel - valeurInit));
    }

    public double getValeur() {
        double value = 0.0;
        for (ActifsIterator it = actifs; it.hasNext(); ) {
            Actif actif = it.next();
            value += actif.getAction().getPrix() * actif.getQuantite();
        }
        return value;
    }
}
