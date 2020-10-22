package Reservation;

import GestionVol.Escale;
import GestionVol.Vol;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Client {
    private String nom;
    private String reference;
    private String paiment;
    private String contact;

    private ArrayList<Reservation> reservations;

    public Client (String nom) {
        this.nom = nom;
        this.reservations = new ArrayList<Reservation>();
    }

    public Reservation reserver (Vol vol, Passager passager){
        if (vol.getEtat()) {
            Reservation r = new Reservation(vol, ZonedDateTime.now(), this, passager);
            reservations.add(r);
            passager.ajouterReservation(r);
            return r;
        }

        return null;
    }

    public String toString (){
        String sRet = "";

        sRet += "Nom = " + this.nom + '\n';
        sRet += '\n';
        for (Reservation r : reservations) {
            sRet += r.toString();
            sRet += '\n';
        }

        return sRet;
    }
}
