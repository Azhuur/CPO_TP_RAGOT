/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package lightoff_nom_version_console;

import java.util.Random;

/**
 *
 * @author Arthur
 */
public class GrilleDeJeu {
    public CelluleLumineuse[][] matriceCellules;
    private int nbLignes;
    private int nbColonnes;

    /**
     * Constructeur de la classe GrilleDeJeu.param nbLignes    Le nombre de lignes de la grille.
     *
     * param nbColonnes  Le nombre de colonnes de la grille.
     * @return 
     */
        public int compterCellulesAllumees() {
        int count = 0;
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if (matriceCellules[i][j].estActive()) {
                    count++;
                }
            }
        }
        return count;
    }
    public boolean estPartieGagnee() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if (!matriceCellules[i][j].estActive()) {
                    return false;
                }
            }
        }
        return true;
    }
  
    public GrilleDeJeu(int nbLignes, int nbColonnes) {
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        matriceCellules = new CelluleLumineuse[nbLignes][nbColonnes];

        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceCellules[i][j] = new CelluleLumineuse();
            }
        }
    }

    /**
     * Éteint toutes les cellules de la grille.
     */
    public void eteindreToutesLesCellules() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceCellules[i][j].eteindreCellule();
            }
        }
    }

    /**
 * Active une ligne de cellules. Toutes les cellules de la ligne identifiée par idLigne
 * doivent changer d'état.
 *
 * @param idLigne Numéro de la ligne à activer.
 */
public void activerLigneDeCellules(int idLigne) {
    // Parcourir toutes les cellules de la ligne idLigne et appeler activerCellule()
    // sur chacune d'entre elles.
    for (int colonne = 0; colonne < nbColonnes; colonne++) {
        matriceCellules[idLigne][colonne].activerCellule();
    }
}

/**
 * Active une colonne de cellules.Toutes les cellules de la colonne identifiée par idColonne
 doivent changer d'état.
 *
 */
public void activerColonneDeCellules(int colonne) {
    for (int i = 0; i < nbLignes; i++) {
        matriceCellules[i][colonne].activerCellule();
    }
}

/**
 * Active la diagonale descendante de cellules. La diagonale descendante est celle qui part
 * du coin supérieur gauche (0,0) au coin inférieur droit (nbLignes-1, nbColonnes-1).
 */
public void activerDiagonaleDescendante() {
    // Parcourir la diagonale descendante de la matrice et appeler activerCellule() sur
    // chaque cellule de la diagonale.
    for (int i = 0; i < Math.min(nbLignes, nbColonnes); i++) {
        matriceCellules[i][i].activerCellule();
    }
}

/**
 * Active la diagonale montante de cellules. La diagonale montante est celle qui part du coin
 * inférieur gauche (nbLignes-1, 0) au coin supérieur droit (0, nbColonnes-1).
 */
public void activerDiagonaleMontante() {
    // Parcourir la diagonale montante de la matrice et appeler activerCellule() sur
    // chaque cellule de la diagonale.
    for (int i = 0; i < Math.min(nbLignes, nbColonnes); i++) {
        matriceCellules[nbLignes - 1 - i][i].activerCellule();
    }
}

/**
 * Active aléatoirement une ligne, une colonne ou une diagonale de cellules.
 */
public void activerLigneColonneOuDiagonaleAleatoire() {
    // Utilise un générateur de nombres aléatoires pour décider si l'on active
    // une ligne, une colonne ou une diagonale. Ensuite, appelez la méthode
    // correspondante en utilisant un autre nombre aléatoire pour choisir
    // la ligne ou la colonne.
    Random random = new Random();
    int choix = random.nextInt(3); // 0 pour ligne, 1 pour colonne, 2 pour diagonale

    if (choix == 0) {
        int ligneAleatoire = random.nextInt(nbLignes);
        activerLigneDeCellules(ligneAleatoire);
    } else if (choix == 1) {
        int colonneAleatoire = random.nextInt(nbColonnes);
        activerColonneDeCellules(colonneAleatoire);
    } else {
        activerDiagonaleDescendante(); // Active la diagonale par défaut
    }
}

/**
 * Mélange la grille aléatoirement un certain nombre de fois.
 *
 * @param nbTours Le nombre de tours de mélange.
 */
public void melangerMatriceAleatoirement(int nbTours) {
    // Effectue nbTours de mélanges en utilisant la méthode
    for (int tour = 0; tour < nbTours; tour++) {
        activerLigneColonneOuDiagonaleAleatoire();
    }
}

/**
 * Vérifie si toutes les cellules de la grille sont éteintes.
 *
 * @return true si toutes les cellules sont éteintes, false sinon.
 */
public boolean cellulesToutesEteintes() {
    // Parcourir toutes les cellules de la grille et vérifier si elles sont éteintes.
    for (int ligne = 0; ligne < nbLignes; ligne++) {
        for (int colonne = 0; colonne < nbColonnes; colonne++) {
            if (!matriceCellules[ligne][colonne].estEteint()) {
                return false; // Au moins une cellule est allumée, donc la grille n'est pas éteinte.
            }
        }
    }
    return true; // Toutes les cellules sont éteintes.
}


@Override
public String toString() {
    StringBuilder gridString = new StringBuilder();

    // Affiche les indices des colonnes
    gridString.append("  ");
    for (int col = 0; col < nbColonnes; col++) {
        gridString.append(col).append(" ");
    }
    gridString.append("\n");

    for (int row = 0; row < nbLignes; row++) {
        // Affiche l'indice de la ligne
        gridString.append(row).append(" ");

        // Affiche l'état des cellules pour cette ligne
        for (int col = 0; col < nbColonnes; col++) {
            gridString.append(matriceCellules[row][col]).append(" ");
        }
        gridString.append("\n");
    }

    return gridString.toString();
}

    public int getNbColonnes() {
        if (matriceCellules.length > 0) {
            return matriceCellules[0].length;
        } else {
            return 0; // Ou renvoyez une valeur par défaut appropriée
        }
    }
      public int getNbLignes() {
        return this.matriceCellules.length;
    }

    public int encoreallumees() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int cellulesencoreallumees() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

} 