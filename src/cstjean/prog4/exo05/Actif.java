package cstjean.prog4.exo05;

public class Actif {
    private Action action;
    private int quantite;

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
