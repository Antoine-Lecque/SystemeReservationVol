package GestionVol;

import java.util.ArrayList;
import java.util.Collection;

public class Ville {
    private String nom;
    private ArrayList<Aeroport> aeroports;

    public Ville(String nom) {
        this.nom = nom;

        this.aeroports = new ArrayList<Aeroport>();
    }

    public void ajouterAeroport (Aeroport a){
        this.aeroports.add(a);;
    }
}
