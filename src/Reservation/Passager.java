package Reservation;

import java.util.ArrayList;

public class Passager {
    private String nom;
    private ArrayList<Reservation> reservations;

    public Passager (String nom) {
        this.nom = nom;
        this.reservations = new ArrayList<Reservation>();
    }

    public void ajouterReservation (Reservation r){
        reservations.add(r);
    }

    public String toString() {
        return this.nom;
    }
}
