package cstjean.prog4.exo05;

public abstract class Observer {
    public abstract void onPrixChanger(Action action, double ancien, double nouveauPrix);
}
