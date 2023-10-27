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

public class Partie {
    private GrilleDeJeu grille;
    private int nbCoups;

    public Partie(GrilleDeJeu grille) {
        this.grille = grille;
        nbCoups = 0;
    }

    public void initialiserPartie() {
        grille.eteindreToutesLesCellules();
        grille.melangerMatriceAleatoirement(50);
    }

    public static void main(String[] args) {
        GrilleDeJeu grille = new GrilleDeJeu(5, 5);
        Partie partie = new Partie(grille);
        partie.initialiserPartie();
        partie.lancerPartie();
    }

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
