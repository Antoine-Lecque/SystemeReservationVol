package GestionVol;

import java.util.ArrayList;

public class Compagnie{
	private String nom;
	private ArrayList<Vol> volsPropose;

	public Compagnie(String nom) {
		this.nom = nom;

		volsPropose = new ArrayList<Vol>();
	}

	public void ajouterVol (Vol v){
		volsPropose.add(v);
	}
}
