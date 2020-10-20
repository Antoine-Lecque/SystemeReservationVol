import GestionVol.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Start {
	public static void main(String[] args){
		//Création d'une compagnie
		Compagnie comp1 = new Compagnie("comp1");

		// Création de l'escale
		Aeroport aeroEscale = new Aeroport("AeroEscale");
		aeroEscale.ajouterVille(new Ville("Amsterdam"));

		ZoneId zoneId = ZoneId.of("UTC+1");
		ZonedDateTime arrEscale = ZonedDateTime.of(2020, 10, 20, 18, 0, 0, 0, zoneId);
		ZonedDateTime depEscale = ZonedDateTime.of(2020, 10, 20, 19, 0, 0, 0, zoneId);

		Escale escale = new Escale(aeroEscale, arrEscale, depEscale);

		//Création du vol
		Aeroport depard = new Aeroport("AeroDep");
		depard.ajouterVille(new Ville("Paris"));

		Aeroport arrivee = new Aeroport("AeroArr");
		arrivee.ajouterVille(new Ville("Berlin"));

		ZonedDateTime dateArrivee = ZonedDateTime.of(2020, 10, 20, 8, 0, 0, 0, zoneId);
		ZonedDateTime dateDepard = ZonedDateTime.of(2020, 10, 20, 22, 0, 0, 0, zoneId);
		Vol vol = new Vol("VOL1", dateDepard, dateArrivee, depard, arrivee);

		comp1.ajouterVol(vol);

		vol.ajouterEscale(escale);

		vol.ouvrir();
		vol.fermer();

    //affichage du vol 
		System.out.println(vol.toString());
	}
}
