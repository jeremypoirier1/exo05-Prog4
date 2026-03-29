package cstjean.prog4.exo05;

public class Actif {
    private final Action action;
    private final int quantite;

    public Actif(Action action, int quantite) {
        this.action = action;
        this.quantite = quantite;
    }

    public Action getAction() {
        return action;
    }

    public int getQuantite() {
        return quantite;
    }
}
