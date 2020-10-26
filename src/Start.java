import GestionVol.*;
import Reservation.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Start {
	public static void main(String[] args){
		//Création d'une compagnie
		Compagnie comp1 = new Compagnie("comp1");

		// Création de  2 escale
		Aeroport aeroEscale = new Aeroport("AeroEscale");
		Aeroport aeroEscale2 = new Aeroport("AeroEscale2");
		Ville v = new Ville("Amsterdam");
		Ville v2 = new Ville("hamburg");

		//vérification que la double navigabilité entre ville et aéroport ne crée pas de boucle.
		System.out.println("-----------------------------------------------");
		System.out.println("Vérification de la double navigabilité");
		System.out.println("-----------------------------------------------");
		aeroEscale.ajouterVille(v);
		System.out.println(v.toString());
		System.out.println(aeroEscale.toString());
		v.ajouterAeroport(aeroEscale);
		System.out.println(v.toString());
		System.out.println(aeroEscale.toString());
		aeroEscale2.ajouterVille(v2);

		ZoneId zoneId = ZoneId.of("UTC+1");
		ZonedDateTime arrEscale = ZonedDateTime.of(2020, 10, 20, 18, 0, 0, 0, zoneId);
		ZonedDateTime depEscale = ZonedDateTime.of(2020, 10, 20, 19, 0, 0, 0, zoneId);
		ZonedDateTime arrEscale2 = ZonedDateTime.of(2020, 10, 20, 21, 0, 0, 0, zoneId);
		ZonedDateTime depEscale2 = ZonedDateTime.of(2020, 10, 20, 21, 30, 0, 0, zoneId);

		Escale escale = new Escale(aeroEscale, arrEscale, depEscale);
		Escale escale2 = new Escale(aeroEscale2, arrEscale2, depEscale2);

		//Création du vol
		Aeroport depard = new Aeroport("AeroDep");
		depard.ajouterVille(new Ville("Paris"));

		Aeroport arrivee = new Aeroport("AeroArr");
		arrivee.ajouterVille(new Ville("Berlin"));


		ZonedDateTime dateDepard = ZonedDateTime.of(2020, 10, 20, 8, 0, 0, 0, zoneId);
		ZonedDateTime dateArrivee = ZonedDateTime.of(2020, 10, 20, 23, 30, 0, 0, zoneId);
		Vol vol1 = new Vol(dateDepard, dateArrivee, depard, arrivee);

		comp1.ajouterVol(vol1);

		vol1.ajouterEscale(escale);
		vol1.ajouterEscale(escale2);

		vol1.ouvrir();

		//affichage du vol
		System.out.println("-----------------------------------------------");
		System.out.println("Affichage du vol créé");
		System.out.println("-----------------------------------------------");
		System.out.println(vol1.toString());

		//Création d'un client et des passagers
		Client client = new Client("Titi","CB","titi@gmail.com");
		Passager passager1 = new Passager("Toto");
		Passager passager2 = new Passager("Tata");
		Passager passager3 = new Passager("Tutu");

		//Le client effectue une reservation pour le vol précédement créé
		Reservation r1 = client.reserver(vol1, passager1);

		System.out.println("--------------------------------------------------------------");
		System.out.println("Affichage des reservations et test état des reservations");
		System.out.println("--------------------------------------------------------------");
		System.out.println(client.toString());
		r1.confirmer();
		System.out.println(client.toString());
		r1.annuler();
		System.out.println(client.toString());

		Reservation r2 = client.reserver(vol1, passager2);
		System.out.println(client.toString());

		vol1.fermer();
		Reservation r3 = client.reserver(vol1, passager3);
		System.out.println(r3);

		// Vol réguliers :
		ZonedDateTime d1 = ZonedDateTime.of(2020, 10, 26, 10, 0, 0, 0, zoneId);
		ZonedDateTime d2 = ZonedDateTime.of(2020, 10, 27, 10, 0, 0, 0, zoneId);
		Vol vol2 = VolRegulier.creerVol(vol1,d1);
		Vol vol3 = VolRegulier.creerVol(vol1,d2);
		System.out.println("---------------------------------------------------");
		System.out.println("Affichage des vols réguliers créés a partir de VOL1");
		System.out.println("---------------------------------------------------");
		System.out.println(vol2.toString());
		System.out.println(vol3.toString());
	}
}
