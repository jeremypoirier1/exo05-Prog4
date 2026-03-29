package cstjean.prog4.exo05;

public class ProfilRelax extends Portefeuille {
    public ProfilRelax(double objectif, ActifsIterator actifs, String name) {
        super(objectif, actifs, name, "Relax");
    }

    @Override
    public boolean verifyObjectif() {
        if (getValeur() < valeurInit) {
            System.out.println("la valeur du portefeuille est inferieur a la valeur initiale");
            return false;
        }
        return super.verifyObjectif();
    }
}
