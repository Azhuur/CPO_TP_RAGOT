/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lightoff_nom_version_console;


/**
 *
 * @author Arthur
 */
public class LightOff_NOM_version_console {
    public static void main(String[] args) {
        // Créez une cellule lumineuse
        CelluleLumineuse cellule = new CelluleLumineuse();

        // Affichez l'état initial de la cellule
        System.out.println("État initial de la cellule : " + cellule);

        // Activez la cellule
        cellule.activerCellule();
        System.out.println("État après activation : " + cellule);

        // Éteignez la cellule
        cellule.eteindreCellule();
        System.out.println("État après extinction : " + cellule);

        // Vérifiez si la cellule est éteinte
        if (cellule.estEteint()) {
            System.out.println("La cellule est éteinte.");
        } else {
            System.out.println("La cellule est allumée.");
        }

        // Obtenez l'état actuel de la cellule
        boolean etatActuel = cellule.getEtat();
        System.out.println("État actuel de la cellule : " + (etatActuel ? "Allumée" : "Éteinte"));
 
        // Créez une instance de la classe GrilleDeCellules
        GrilleDeJeu grille = new GrilleDeJeu(5, 5); // Remplacez les dimensions selon vos préférences

        // Créez une instance de la classe Partie
        Partie partie = new Partie(grille);

        // Initialisez la partie
        partie.initialiserPartie();

        // Lancez la partie
        partie.lancerPartie();

        // À ce stade, le jeu est joué et le programme affichera un message de félicitations
        // lorsque toutes les cellules seront éteintes.
    }
    }
