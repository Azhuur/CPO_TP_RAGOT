/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp2_relation_ragot;
/**
 *
 * @author Arthur
 */
public class TP2_relation_1_RAGOT {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {
        Voiture uneClio = new Voiture("Clio", "Renault", 5);
        Voiture uneAutreClio = new Voiture("Clio", "Renault", 5);
        Voiture une2008 = new Voiture("2008", "Peugeot", 6);
        Voiture uneMicra = new Voiture("Micra", "Nissan", 4);

        Personne bob = new Personne("Bobby", "Sixkiller");
        Personne reno = new Personne("Reno", "Raines");

        bob.ajouterVoiture(uneClio);
        bob.ajouterVoiture(une2008);
        reno.ajouterVoiture(uneMicra);
        reno.ajouterVoiture(uneAutreClio);

        System.out.println(bob + " possède les voitures suivantes:");
        for (int i = 0; i < bob.nbVoitures; i++) {
            System.out.println(bob.liste_voitures[i]);
        }

        System.out.println();

        System.out.println(reno + " possède les voitures suivantes:");
        for (int i = 0; i < reno.nbVoitures; i++) {
            System.out.println(reno.liste_voitures[i]);
        }
    }
}
public class Voiture {
String modele;
    String marque;
    int nbPlaces;
    Personne proprietaire;

    public Voiture(String modele, String marque, int nbPlaces) {
        this.modele = modele;
        this.marque = marque;
        this.nbPlaces = nbPlaces;
        this.proprietaire = null;
    }

    @Override
    public String toString() {
        return "Voiture " + modele + " de marque " + marque + " avec " + nbPlaces + " places.";
    }
}
public class Personne {
 String nom;
    String prenom;
    int nbVoitures;
    Voiture[] liste_voitures;

    public Personne(String prenom, String nom) {
        this.nom = nom;
        this.prenom = prenom;
        this.nbVoitures = 0;
        this.liste_voitures = new Voiture[3];
    }

    public boolean ajouterVoiture(Voiture voiture) {
        if (voiture.proprietaire != null) {
            System.out.println("La voiture est déjà possédée par quelqu'un d'autre.");
            return false;
        }

        if (nbVoitures >= 3) {
            System.out.println("Le propriétaire a déjà 3 voitures, impossible d'en ajouter plus.");
            return false;
        }

        liste_voitures[nbVoitures] = voiture;
        voiture.proprietaire = this;
        nbVoitures++;

        return true;
    }

    @Override
    public String toString() {
        return prenom + " " + nom;
    }
}   
