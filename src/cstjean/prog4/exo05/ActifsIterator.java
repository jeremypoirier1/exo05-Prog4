package cstjean.prog4.exo05;

import java.util.List;

public class ActifsIterator {
    private List<Actif> actifs;
    private int index = 0;

    public ActifsIterator(List<Actif> actifs) {
        this.actifs = actifs;
    }

    public boolean hasNext() {
        return index < actifs.size();
    }
    public Actif next() {
        return actifs.get(index++);
    }
}
