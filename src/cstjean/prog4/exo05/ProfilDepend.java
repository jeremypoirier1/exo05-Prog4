package cstjean.prog4.exo05;

public class ProfilDepend extends Portefeuille {
    public ProfilDepend(double objectif, ActifsIterator actifs, String name) {
        super(objectif, actifs, name, "Ça dépend");
    }

    @Override
    public boolean verifyObjectif() {
        if (isActionDown()) {
            if ()
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

    public boolean isActionDownBy5 {
        for (ActifsIterator it = actifs; it.hasNext(); ) {
            Actif actif = it.next();
            if (actif.getAction().getAncien() - actif.getAction().getPrix() >= 5) {
                return true;
            }
        }
        return false;
    }
}
