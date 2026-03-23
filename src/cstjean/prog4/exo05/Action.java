package cstjean.prog4.exo05;

import java.util.ArrayList;
import java.util.List;

public class Action {
    private String nom;
    private double prix;
    private double ancien;
    private boolean isDown;
    private List<Observer> observers = new ArrayList<>();
    public Action(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
        this.ancien = 0;
    }
    public String getNom() {
        return nom;
    }
    public double getPrix() {
        return prix;
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

    public void setPrix(double nouveauPrix) {
        double ancien = prix;
        prix = nouveauPrix;
        if (ancien > prix) {
            isDown = true;
        }
        else {
            isDown = false;
        }
        System.out.println("\n" + nom + " : " + ancien + "$ --->" + nouveauPrix + "$");
        for (Observer obs : observers) {
            obs.onPrixChanger(this, ancien, nouveauPrix);
        }
    }
}
