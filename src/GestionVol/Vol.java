package GestionVol;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class Vol{
	private static int num;
    private String numero;

	private ZonedDateTime dateDepard;
	private ZonedDateTime dateArrivee;
	private Duration duree;

	private Aeroport depart;
	private Aeroport arrivee;
	private ArrayList<Escale> escales;

	public boolean etatVol;

	public Vol (ZonedDateTime dateDepard, ZonedDateTime dateArrivee, Aeroport depard, Aeroport arrivee){
		this.numero = "VOL"+ ++num;

		this.dateArrivee = dateArrivee;
		this.dateDepard = dateDepard;
		this.duree = Duration.between(dateDepard, dateArrivee);

		this.depart = depard;
		this.arrivee = arrivee;
		this.escales = new ArrayList<Escale>();
	}

	public void ouvrir(){
		this.etatVol = true;
	}

	public void fermer(){
		this.etatVol = false;
	}

	public void ajouterEscale (Escale e) {
		this.escales.add(e);
	}


	public boolean getEtat() {
		return etatVol;
	}

	public String getNumero() {
		return numero;
	}

	public Aeroport getDepart() {return this.depart; }

	public Aeroport getArrivee() { return this.arrivee; }

	public Duration getDuree() { return this.duree; }

	public ZonedDateTime getDateDepard() { return this.dateDepard; }

	public ZonedDateTime getDateArrivee() { return this.dateArrivee; }

	public ArrayList<Escale> getEscales () { return this.escales; }


	@Override
	public String toString() {
		String sRet = "";

		sRet += "|------ VOL ------" + '\n';
		sRet += "| Numero : " + this.numero + '\n';
		sRet += "| \n";
		sRet += "| Aeroport de depard : " + this.depart.toString();
		sRet += "| Date de depard : " + this.dateDepard.toString() + '\n';
		sRet += "| \n";
		sRet += "| Aeroport d'arrivee : " + this.arrivee.toString();
		sRet += "| Date d'arrivee : " + this.dateArrivee.toString() + '\n';
		sRet += "| \n";
		for (Escale e : escales) {
			sRet += e.toString();
		}
		sRet += "| \n";
		sRet += "| Duree : " + this.duree.toString() + '\n';
		sRet += "| \n";
		sRet += "| Etat du vol : " + this.etatVol + '\n';
		return sRet;
	}
}
