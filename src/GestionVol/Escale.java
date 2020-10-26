package GestionVol;

import java.time.Duration;
import java.time.ZonedDateTime;

public class Escale {
    private Aeroport aeroport;
    private ZonedDateTime depard;
    private ZonedDateTime arrivee;
    private Duration duree;

    public Escale (Aeroport aeroport, ZonedDateTime arrivee, ZonedDateTime depard) {
        this.aeroport = aeroport;
        this.arrivee = arrivee;
        this.depard = depard;

        this.duree = Duration.between(depard, arrivee);
    }

    // Retourne une instance d'Escale avec le meme aeroport
    // et avec une date d'arrivee et de depart decalé de la durée diff
    public Escale escalePlusDiff(Duration diff) {
        return new Escale(this.aeroport, this.arrivee.plus(diff),this.depard.plus(diff));
    }

    @Override
    public String toString() {
        String sRet = "";
        sRet += "| |Aeroport : " + this.aeroport;
        sRet += "| | \n";
        sRet += "| | Date d'arrivee : " + this.arrivee.toString() + '\n';
        sRet += "| | \n";
        sRet += "| | Date de depard : " + this.depard.toString() + '\n';
        sRet += "| | \n";
        sRet += "| | Duree : " + this.duree.toString() + '\n';

        return sRet;
    }
}
