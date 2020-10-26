package GestionVol;

import java.util.ArrayList;

public class Ville {
    private String nom;
    private ArrayList<Aeroport> aeroports;

    public Ville(String nom) {
        this.nom = nom;

        this.aeroports = new ArrayList<Aeroport>();
    }

    public void ajouterAeroport (Aeroport a){
        if (!countains(a)) {
            this.aeroports.add(a);
        }

        if (!a.countains(this)) {
            a.ajouterVille(this);
        }
    }

    public boolean countains(Aeroport a) {
        return this.aeroports.contains(a);
    }

    public String getNom (){
        return this.nom;
    }

    public String toString() {
        String sRet = "";
        for (Aeroport a : aeroports) {
            sRet += a.getNom();
            sRet += '\n';
        }
        return sRet;
    }
}
