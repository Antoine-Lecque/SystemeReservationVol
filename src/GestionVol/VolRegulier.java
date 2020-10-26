package GestionVol;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;

public class VolRegulier {
    public VolRegulier (){
    }

    public static Vol creerVol (Vol vol,ZonedDateTime depart) {
        Duration diff = Duration.between(vol.getDateDepard(), depart);
        ZonedDateTime dateDepard =  depart;
        ZonedDateTime dateArrivee = vol.getDateArrivee().plus(diff);

        Vol nouveauVol = new Vol(dateDepard, dateArrivee, vol.getDepart(), vol.getArrivee());

        for(Escale e : vol.getEscales() ){
            nouveauVol.ajouterEscale(e.escalePlusDiff(diff));
        }

        return nouveauVol;
    }
}
