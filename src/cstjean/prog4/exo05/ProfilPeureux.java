package cstjean.prog4.exo05;

public class ProfilPeureux extends Portefeuille {
    public ProfilPeureux(double objectif, ActifsIterator actifs, String name) {
        super(objectif, actifs, name, "Peureux");
    }

    @Override
    public boolean verifyObjectif() {
        if (valeurInit > getValeur() && isActionDown()) {
            System.out.println("Action a la baisse");
            return true;
        }
        return super.verifyObjectif();
    }
}