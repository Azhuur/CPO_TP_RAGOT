/* 
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import lightoff_nom_version_console.CelluleLumineuse;

public class CelluleGraphique extends JButton {

    int largeur; // largeur en pixel de la cellule
    int hauteur; // hauteur en pixel de la cellule
    CelluleLumineuse celluleLumineuseAssociee;

    // constructeur (appelé depuis FenetrePrincipale)
    public CelluleGraphique(CelluleLumineuse celluleLumineuseAssociee, int l, int h) {
        this.largeur = l;
        this.hauteur = h;
        this.celluleLumineuseAssociee = celluleLumineuseAssociee;
    }

    // Methode gérant le dessin de la cellule
    @Override
    protected void paintComponent(Graphics g) {
        int w = this.getWidth();
        int h = this.getHeight();
        if (celluleLumineuseAssociee.estEteint() == true) {
            g.setColor(Color.yellow);
        } else {
            g.setColor(Color.white);
        }
        g.fillOval(2, 2, w - 4, h - 4);
    }
}