/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Arthur
 */
public class BouteilleBiere {

    String nom;          
    float degreAlcool;   
    String brasserie;   
    boolean ouverte;     
    
public void lireEtiquette() {
System.out.println("Bouteille de " + nom +" (" + degreAlcool +
" degres) \nBrasserie : " + brasserie ) ;
}

public boolean decapsuler() {
    if (ouverte == false) {
        return true; // Ouverture réussie
    } else {
        System.out.println("Erreur : biere déjà ouverte");
        return false; // Ouverture échouée
    }
}
public BouteilleBiere(String unNom, float unDegre, String
uneBrasserie) {
nom = unNom;
degreAlcool = unDegre;
brasserie = uneBrasserie;
ouverte = false;
}

public class Main {
    public static void main(String[] args) {
        
        BouteilleBiere uneBiere = new BouteilleBiere("Cuvée des trolls", 7.0f, "Dubuisson");
        uneBiere.lireEtiquette();
        uneBiere.decapsuler();
        System.out.println(uneBiere);

        System.out.println(); 

        
        BouteilleBiere autreBiere1 = new BouteilleBiere("Bière1", 5.5f, "Brasserie1");
        BouteilleBiere autreBiere2 = new BouteilleBiere("Bière2", 6.0f, "Brasserie2");
        BouteilleBiere autreBiere3 = new BouteilleBiere("Bière3", 4.8f, "Brasserie3");

        autreBiere1.lireEtiquette();
        autreBiere2.lireEtiquette();
        autreBiere3.lireEtiquette();
    }
}

}