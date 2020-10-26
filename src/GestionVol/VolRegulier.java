package GestionVol;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class VolRegulier {
    private Aeroport depart;
    private Aeroport arrivee;
    private ArrayList<Escale> escales;

    public VolRegulier (Aeroport depard, Aeroport arrivee, ArrayList<Escale> escales){
        this.depart = depard;
        this.arrivee = arrivee;
        this.escales = escales;
    }

    public Vol creerVol (ZonedDateTime dateDepard, ZonedDateTime dateArrivee) {
        return new Vol(dateDepard, dateArrivee, this.depart, this.arrivee);
    }
}
