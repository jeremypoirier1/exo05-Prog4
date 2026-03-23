package cstjean.prog4.exo05;

public class ProfilPeureux extends Portefeuille {
    public ProfilPeureux(double objectif, ActifsIterator actifs, String name) {
        super(objectif, actifs, name, "Peureux");
    }

    @Override
    public boolean verifyObjectif() {
        if (valeurInit > getValeur() && isActionDown()) {
            System.out.println("Action a la baisse");
            sellAction();
            return true;
        }
        System.out.println("Rien effectué");
        return false;
    }

    public boolean isActionDown() {
        for (ActifsIterator it = actifs; it.hasNext(); ) {
            Actif actif = it.next();
            if (actif.getAction().getIsDown()) {
                return true;
            }
        }
        return false;
    }
}