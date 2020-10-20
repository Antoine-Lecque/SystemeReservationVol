package GestionVol;

import java.time.Duration;
import java.time.ZonedDateTime;

public class Escale {
    private Aeroport aeroport;
    private ZonedDateTime depard;
    private ZonedDateTime arrivee;
    private Duration duree;

    public Escale (Aeroport aeroport, ZonedDateTime depard, ZonedDateTime arrivee) {
        this.aeroport = aeroport;
        this.arrivee = arrivee;
        this.depard = depard;

        this.duree = Duration.between(depard, arrivee);
    }

    @Override
    public String toString() {
        String sRet = "";
        sRet += "| |------ ESCALE ------|" + '\n';
        sRet += "| |Aeroport : " + this.aeroport + '\n';
        sRet += "| | \n";
        sRet += "| | Date d'arrivee : " + this.arrivee.toString() + '\n';
        sRet += "| | \n";
        sRet += "| | Date de depard : " + this.depard.toString() + '\n';
        sRet += "| | \n";
        sRet += "| | Duree : " + this.duree.toString() + '\n';

        return sRet;
    }
}
