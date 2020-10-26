package Reservation;

import GestionVol.Vol;

import java.time.ZonedDateTime;
import java.util.ArrayList;

public class Client {
    private static int num;

    private String nom;
    private String reference;
    private String paiment;
    private String contact;

    private ArrayList<Reservation> reservations;

    public Client (String nom, String paiment, String contact) {
        this.reference = "CLIENT"+ ++num;

        this.nom     = nom;
        this.paiment = paiment;
        this.contact = contact;

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
