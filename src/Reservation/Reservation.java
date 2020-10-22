package Reservation;

import GestionVol.Vol;

import java.time.ZonedDateTime;
import java.util.Date;

public class Reservation {
    private static int n = 1;
    private String numero;
    private ZonedDateTime date;

    private Vol vol;

    private EtatReservation etat;

    private Client client;
    private Passager passager;

    public Reservation (Vol vol, ZonedDateTime date, Client client, Passager passager){
        this.numero = "RESERV" + n++;

        this.vol = vol;
        this.date = date;

        this.client = client;
        this.passager = passager;

        etat = EtatReservation.EN_ATTENTE;
    }

    public void confirmer(){
        switch(etat){
            case EN_ATTENTE :
            case CONFIRMER :
                this.etat = EtatReservation.CONFIRMER;
                break;
            default : throw new IllegalStateException();
        }
    }

    public void annuler (){
        switch(etat){
            case EN_ATTENTE :
            case ANNULEE:
            case CONFIRMER:
                this.etat = EtatReservation.ANNULEE;
        }
    }

    public String toString () {
        String sRet = "";

        sRet += "Numero : " + this.numero + '\n';
        sRet += "Date : " + this.date.toString() + '\n';
        sRet += "Etat de la reservation : " + this.etat + '\n';
        sRet += "Passager : " + this.passager.toString() + '\n';
        sRet += "Numero du vol : " +  this.vol.getNumero() + '\n';

        return sRet;
    }
        private enum EtatReservation {
        EN_ATTENTE, ANNULEE, CONFIRMER
    }
}
