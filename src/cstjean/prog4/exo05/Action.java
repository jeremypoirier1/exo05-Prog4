package cstjean.prog4.exo05;

import java.util.ArrayList;
import java.util.List;

public class Action {
    private final String nom;
    private double prix;
    private double ancien;
    private final double prixInitial;
    private boolean isDown;
    private final List<Observer> observers = new ArrayList<>();

    public Action(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
        this.ancien = 0;
        this.prixInitial = prix;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public double getPrixInitial() {
        return prixInitial;
    }


    public void setPrix(double nouveauPrix) {
        ancien = prix;
        prix = nouveauPrix;
        isDown = ancien > prix;
        System.out.println("\n" + nom + " : " + ancien + "$ --->" + nouveauPrix + "$");
        for (Observer obs : observers) {
            obs.onPrixChanger(this, ancien, nouveauPrix);
        }
    }

    public double getAncien() {
        return ancien;
    }

    public boolean getIsDown() {
        return isDown;
    }

    public void subscribe(Observer obs) {
        observers.add(obs);
    }
}
