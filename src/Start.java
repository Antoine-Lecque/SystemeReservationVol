import GestionVol.*;
import Reservation.*;

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

    //affichage du vol 
		System.out.println(vol.toString());

		//Création d'un client et des passagers
		Client client = new Client("Titi");
		Passager passager1 = new Passager("Toto");
		Passager passager2 = new Passager("Tata");
		Passager passager3 = new Passager("Tutu");

		//Le client effectue une reservation pour le vol précédement créé
		Reservation r1 = client.reserver(vol, passager1);

		System.out.println(client.toString());
		r1.confirmer();
		System.out.println(client.toString());
		r1.annuler();
		System.out.println(client.toString());

		Reservation r2 = client.reserver(vol, passager2);
		System.out.println(client.toString());

		vol.fermer();
		Reservation r3 = client.reserver(vol, passager3);
		System.out.println(r3);
	}
}
