package GestionVol;

import java.util.ArrayList;

public class Aeroport {
    private String nom;
    private ArrayList<Ville> villesDeservies;

    public Aeroport(String nom) {
        this.nom = nom;

        this.villesDeservies = new ArrayList<Ville>();
    }

    public void ajouterVille(Ville v) {
        this.villesDeservies.add(v);
    }

    @Override
    public String toString() {
        return this.nom;
    }
}
