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
        if (!countains(v)) {
            this.villesDeservies.add(v);
        }

        if (!v.countains(this)) {
            v.ajouterAeroport(this);
        }
    }

    public boolean countains(Ville v) {
        return this.villesDeservies.contains(v);
    }

    public String getNom() {
        return this.nom;
    }

    @Override
    public String toString() {
        String sRet = "";
        for (Ville v : villesDeservies) {
            sRet += v.getNom();
            sRet += '\n';
        }
        return sRet;
    }


}
