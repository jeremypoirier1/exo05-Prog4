package cstjean.prog4.exo05;

public class ProfilDepend extends Portefeuille {

    private Actif actifDownBy5;
    public ProfilDepend(double objectif, ActifsIterator actifs, String name) {
        super(objectif, actifs, name, "Ça dépend");
    }

    @Override
    public boolean verifyObjectif() {
        if (isActionDown()) {
            if (isActionDownBy5()) {
                if (isActionDownBy5Is50Percent()) {
                    System.out.println("Action a la baisse de plus de 5.00 et compose plus de 50% de la valeur du portefeuille");
                    sellAction();
                    return true;
                }
            }
        }
        System.out.println("Rien effectué");
        return false;
    }

    public boolean isActionDownBy5() {
        for (ActifsIterator it = actifs; it.hasNext(); ) {
            Actif actif = it.next();
            if (actif.getAction().getAncien() - actif.getAction().getPrix() >= 5) {
                actifDownBy5 = actif;
                return true;
            }
        }
        return false;
    }

    private boolean isActionDownBy5Is50Percent() {
        int nbActifs = 0;
        int nbActifDownBy5 = 0;
        for (ActifsIterator it = actifs; it.hasNext(); ) {
            Actif actif = it.next();
            if (actif.getAction() == actifDownBy5.getAction()) {
                nbActifDownBy5++;
            }
            nbActifs++;
        }
        return (double) nbActifDownBy5 / nbActifs >= 0.5;
    }
}
