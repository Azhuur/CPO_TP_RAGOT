/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lightoff_nom_version_console;

/**
 *
 * @author Arthur
 */

import java.util.Scanner;

/**
 * La classe Partie représente le jeu et gère son déroulement.
 */
public class Partie {
    private GrilleDeJeu grille;
    private int nbCoups;

    /**
     * Constructeur de la classe Partie.
     *
     * @param grille La grille de jeu à utiliser pour la partie.
     */
    public Partie(GrilleDeJeu grille) {
        this.grille = grille;
        nbCoups = 0;
    }

    /**
     * Initialise une nouvelle partie en éteignant toutes les cellules de la grille
     * et en les mélangeant aléatoirement.
     */
    public void initialiserPartie() {
        grille.eteindreToutesLesCellules();
        grille.melangerMatriceAleatoirement(50);
    }

    /**
     * entrée du jeu.
     *
     * @param args Les arguments de la ligne de commande (non utilisés).
     */
    public static void main(String[] args) {
        GrilleDeJeu grille = new GrilleDeJeu(5, 5);
        Partie partie = new Partie(grille);
        partie.initialiserPartie();
        partie.lancerPartie();
    }

    /**
     * Démarre la partie et gère les tours 
     */
    public void lancerPartie() {
        Scanner scanner = new Scanner(System.in);

        while (!grille.cellulesToutesEteintes()) {
            System.out.println("Grille actuelle après " + nbCoups + " coups :");
            System.out.println(grille);

            System.out.println("Entrez le coup (ligne/colonne/diagonale) à jouer :");
            String coup = scanner.nextLine();

            if (coup.equalsIgnoreCase("ligne")) {
                System.out.println("Entrez le numéro de la ligne à activer :");
                int numeroLigne = scanner.nextInt();
                grille.activerLigneDeCellules(numeroLigne);
            } else if (coup.equalsIgnoreCase("colonne")) {
                System.out.println("Entrez le numéro de la colonne à activer :");
                int numeroColonne = scanner.nextInt();
                grille.activerColonneDeCellules(numeroColonne);
            } else if (coup.equalsIgnoreCase("diagonale")) {
                grille.activerDiagonaleDescendante();
            } else {
                System.out.println("Coup invalide. Entrez 'ligne', 'colonne' ou 'diagonale'.");
            }

            nbCoups++;
        }

        System.out.println("Félicitations, vous avez éteint toutes les cellules en " + nbCoups + " coups !");
    }
}
