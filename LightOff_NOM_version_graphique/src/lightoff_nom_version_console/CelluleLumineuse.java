/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lightoff_nom_version_console;

/**
 *
 * @author Arthur
 */
public class CelluleLumineuse {
    private boolean etat;

    /**
     * Constructeur par défaut, initialise la cellule en état éteint.
     */
    public CelluleLumineuse() {
        etat = false;
    }

    /**
     * Active la cellule en inversant son état actuel.
     */
    public void activerCellule() {
        etat = !etat;
    }

    /**
     * Éteint la cellule en la mettant dans l'état éteint.
     */
   public void eteindreCellule() {
    etat = false;
}

    /**
     * Vérifie si la cellule est éteinte.
     *
     * @return true si la cellule est éteinte, false sinon.
     */
    public boolean estEteint() {
        return !etat;
    }

    /**
     * Obtient l'état actuel de la cellule.
     *
     * @return true si la cellule est allumée, false si elle est éteinte.
     */
    public boolean getEtat() {
        return etat;
    }

    @Override
    public String toString() {
        return (etat ? "0" : "X");
    }
public boolean estActive() {
    return etat; // Retourne l'état actuel de la cellule (true si allumée, false sinon)
}

    void mettreAJourApparence() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}