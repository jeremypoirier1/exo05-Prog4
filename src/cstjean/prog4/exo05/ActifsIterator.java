package cstjean.prog4.exo05;

import java.util.Iterator;
import java.util.List;

public class ActifsIterator implements Iterator<Actif> {
    private List<Actif> actifs;
    private int index = 0;

    public ActifsIterator(List<Actif> actifs) {
        this.actifs = actifs;
    }

    @Override
    public boolean hasNext() {
        return index < actifs.size();
    }
    @Override
    public Actif next() {
        return actifs.get(index++);
    }
}
