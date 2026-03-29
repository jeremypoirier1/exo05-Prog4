package cstjean.prog4.exo05;

import java.util.ArrayList;
import java.util.List;

public class ProfilDepend extends Portefeuille {

    private List<Actif> actifDownBy5;

    public ProfilDepend(double objectif, ActifsIterator actifs, String name) {
        super(objectif, actifs, name, "Ça dépend");
    }

    @Override
    public boolean verifyObjectif() {
        if (isActionDown()) {
            if (isActionDownBy5()) {
                if (isActionDownBy5Is50Percent()) {
                    System.out.println("Action a la baisse de plus de 5.00 et compose plus de 50% de la valeur du portefeuille");
                    return true;
                }
            }
        }

        return super.verifyObjectif();
    }

    public boolean isActionDownBy5() {
        actifs.reset();
        actifDownBy5 = new ArrayList<>();
        for (ActifsIterator it = actifs; it.hasNext(); ) {
            Actif actif = it.next();
            if (actif.getAction().getAncien() - actif.getAction().getPrix() >= 5) {
                actifDownBy5.add(actif);
            }
        }
        return !actifDownBy5.isEmpty();
    }

    private boolean isActionDownBy5Is50Percent() {
        actifs.reset();
        int nbActifs = 0;
        int nbActifDownBy5 = 0;
        for (ActifsIterator it = actifs; it.hasNext(); ) {
            Actif actif = it.next();
            for (Actif actifDownBy5 : actifDownBy5) {
                if (actif.getAction() == actifDownBy5.getAction()) {
                    nbActifDownBy5 += actif.getQuantite();
                }
            }
            nbActifs += actif.getQuantite();
        }
        return (double) nbActifDownBy5 / nbActifs >= 0.5;
    }
}
