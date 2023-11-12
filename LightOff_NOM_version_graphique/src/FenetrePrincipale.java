/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Arthur
 */
import FenetreVictoire.FenetreVictoire;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import lightoff_nom_version_console.GrilleDeJeu;

public class FenetrePrincipale extends javax.swing.JFrame {


GrilleDeJeu grille;
    /**
     * Creates new form FenetrePrincipale
     */
    
    public FenetrePrincipale() {
    JFrame fenetrePrincipale = this;

    // Afficher la fenêtre de règles avant de créer la fenêtre principale
    FenetreRegles fenetreRegles = new FenetreRegles(fenetrePrincipale, fenetrePrincipale);
    fenetreRegles.setVisible(true);
        
    initComponents();
    int nbLignes = 8;
    int nbColonnes = 8;
    
    getContentPane().add(PanneauGrille, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, nbColonnes * 50, nbLignes * 50));
    this.pack();
    this.revalidate();
    PanneauGrille.setLayout(new GridLayout(nbLignes, nbColonnes));
    
    jProgressBar1.setMaximum(100);
    jProgressBar1.setMinimum(0);
    
    this.grille = new GrilleDeJeu(nbLignes, nbColonnes);
    PanneauGrille.setLayout(new GridLayout(nbLignes, nbColonnes));
    
    // Génération aléatoire de cellules allumées
    int nbCellulesAllumeesAleatoires = 20; // Ajustez selon vos besoins
    grille.melangerMatriceAleatoirement(nbCellulesAllumeesAleatoires);
    
    for (int i = 0; i < nbLignes; i++) {
        for (int j = 0; j < nbColonnes; j++) {
            CelluleGraphique bouton_cellule = new CelluleGraphique(grille.matriceCellules[i][j], 36, 36);
            PanneauGrille.add(bouton_cellule); // ajout au JPanel PanneauGrille
            this.pack();
            this.revalidate();
        }
        
    }
       
    this.getContentPane().setBackground(new Color(23, 87, 50));
   
// Positionnement de la barre de boutons placé a la verticale
        PanneauBoutonsVerticaux.setLayout(new GridLayout(nbLignes, 1));
        getContentPane().add(PanneauBoutonsVerticaux, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1 * 50, nbLignes * 50));
        this.pack();
        this.revalidate();
        
        // Positionnement de la barre de boutons placé a l'horizontale
        PanneauBoutonsHorizontaux.setLayout(new GridLayout(1, nbColonnes)); // Inverser les arguments pour avoir 1 ligne et plusieurs colonnes
        int PositionEnBas = (nbLignes * 50) + 50;
        getContentPane().add(PanneauBoutonsHorizontaux, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, PositionEnBas, nbColonnes * 50, 1 * 50)); // Ajuster les dimensions pour la grille horizontale
        this.pack();
        this.revalidate();
        
        // Positionnement de la barre de Progressioz
        PanneauAvancement.setLayout(new GridLayout(nbLignes, 1));
        int Position3 = PositionEnBas + 100;
        getContentPane().add(PanneauAvancement, new org.netbeans.lib.awtextra.AbsoluteConstraints(Position3 + 40, 20, 40, nbLignes * (nbLignes * 50)));
        
        PanneauAvancement.setLayout(new GridLayout(nbLignes, 1));
        int nouvelleHauteurAvancement = nbLignes * 40;
        getContentPane().add(PanneauAvancement, new org.netbeans.lib.awtextra.AbsoluteConstraints(Position3 + 40, 20, 40, nouvelleHauteurAvancement));
        this.pack();
        this.revalidate();
        
        // Positionnement de diagoG à gauche de PanneauBoutonsHorizontaux
        diagoG.setLayout(new GridLayout(1, 1)); // Définir la disposition pour diagoG
        getContentPane().add(diagoG, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450));
        
        // Positionnement de diagoG à droite de PanneauBoutonsHorizontaux
        diagoD.setLayout(new GridLayout(1, 1)); // Définir la disposition pour diagoD
        getContentPane().add(diagoD, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 450));
       
                
        
        jProgressBar1.setMaximum(nbLignes * nbColonnes);
    jProgressBar1.setMinimum(0);
    int nbrCellulesAllumees = grille.compterCellulesAllumees();
    jProgressBar1.setValue(nbrCellulesAllumees);
    repaint();
 
        
        
// création du panneau de boutons verticaux (pour les lignes)
for (int i = 0; i < nbLignes; i++) {
JButton bouton_ligne = new JButton();
final int j = i;
ActionListener ecouteurClick = new ActionListener() {


@Override
                public void actionPerformed(ActionEvent e) {
                    grille.activerLigneDeCellules(j);
                    jProgressBar1.setMaximum(nbLignes * nbColonnes);
                    jProgressBar1.setMinimum(0);
                    int nbrCelluesetteintes = grille.compterCellulesAllumees();
                    jProgressBar1.setValue(nbrCelluesetteintes);
                    
                    if ((nbrCelluesetteintes - nbLignes * nbColonnes ) == 0 ) {
                        dispose();
                        FenetreVictoire f = new FenetreVictoire() ;
                        f.setVisible(true) ;
                        
                    }
                    repaint();
                }
            };
            bouton_ligne.addActionListener(ecouteurClick);
            PanneauBoutonsVerticaux.add(bouton_ligne);
        }
    
    // Création du panneau de boutons horizontaux (pour les colonnes)
    for (int i = 0; i < nbColonnes; i++) {
        JButton bouton_colonne = new JButton();
        final int j = i;
        ActionListener ecouteurClick = new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                grille.activerColonneDeCellules(j);
                jProgressBar1.setMaximum(nbLignes * nbColonnes);
                jProgressBar1.setMinimum(0);
                int nbrCellulesAllumees = grille.compterCellulesAllumees();
                jProgressBar1.setValue(nbrCellulesAllumees);

                if (nbrCellulesAllumees == nbLignes * nbColonnes) {
                    dispose();
                    FenetreVictoire f = new FenetreVictoire();
                    f.setVisible(true);
                }

                repaint();
            }
        };
        
        bouton_colonne.addActionListener(ecouteurClick);
        PanneauBoutonsHorizontaux.add(bouton_colonne);
        
    }
    
    //Création du bouton diagonale gauche
    JButton boutonDiagonaleGauche = new JButton();
    ActionListener ecouteurClickDiagonaleGauche = new ActionListener() {


        @Override
            public void actionPerformed(ActionEvent e) {
                grille.activerDiagonaleMontante();
                jProgressBar1.setMaximum(nbLignes * nbColonnes);
                jProgressBar1.setMinimum(0);
                int nbrCellulesAllumees = grille.compterCellulesAllumees();
                jProgressBar1.setValue(nbrCellulesAllumees);

                if (nbrCellulesAllumees == nbLignes * nbColonnes) {
                    dispose();
                    FenetreVictoire f = new FenetreVictoire();
                    f.setVisible(true);
                }
                
                repaint();
            }
    };
    
    boutonDiagonaleGauche.addActionListener(ecouteurClickDiagonaleGauche);
    diagoG.add(boutonDiagonaleGauche);
    // Définir la taille du bouton
    int nouvelleLargeur = 50; // Spécifiez la nouvelle largeur en pixels
    int nouvelleHauteur = 50; // Spécifiez la nouvelle hauteur en pixels
    boutonDiagonaleGauche.setPreferredSize(new Dimension(nouvelleLargeur, nouvelleHauteur));

    
    //Création du bouton diagonale gauche
    JButton boutonDiagonaleDroit = new JButton();
    ActionListener ecouteurClickDiagonaleDroit = new ActionListener() {


        @Override
            public void actionPerformed(ActionEvent e) {
                grille.activerDiagonaleDescendante();
                jProgressBar1.setMaximum(nbLignes * nbColonnes);
                jProgressBar1.setMinimum(0);
                int nbrCellulesAllumees = grille.compterCellulesAllumees();
                jProgressBar1.setValue(nbrCellulesAllumees);

                if (nbrCellulesAllumees == nbLignes * nbColonnes) {
                    dispose();
                    FenetreVictoire f = new FenetreVictoire();
                    f.setVisible(true);
                }
                
                repaint();
            }
    };
    
    boutonDiagonaleDroit.addActionListener(ecouteurClickDiagonaleDroit);
    diagoD.add(boutonDiagonaleDroit);
    // Définir la taille du bouton
    int nouvelleLargeur2 = 50; //  nouvelle largeur 
    int nouvelleHauteur2 = 50; //  la nouvelle hauteur 
    boutonDiagonaleDroit.setPreferredSize(new Dimension(nouvelleLargeur, nouvelleHauteur));
    
    } 


public void initialiserPartie() {
    grille.eteindreToutesLesCellules();
    grille.melangerMatriceAleatoirement(10);

}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanneauGrille = new javax.swing.JPanel();
        PanneauBoutonsVerticaux = new javax.swing.JPanel();
        PanneauBoutonsHorizontaux = new javax.swing.JPanel();
        PanneauAvancement = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        diagoG = new javax.swing.JPanel();
        sapin = new javax.swing.JLabel();
        diagoD = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(2017, 2647));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanneauGrille.setBackground(new java.awt.Color(241, 21, 46));
        PanneauGrille.setToolTipText("");
        PanneauGrille.setLayout(new java.awt.GridLayout(1, 0));
        getContentPane().add(PanneauGrille, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 220, 220));

        PanneauBoutonsVerticaux.setBackground(new java.awt.Color(51, 117, 48));

        javax.swing.GroupLayout PanneauBoutonsVerticauxLayout = new javax.swing.GroupLayout(PanneauBoutonsVerticaux);
        PanneauBoutonsVerticaux.setLayout(PanneauBoutonsVerticauxLayout);
        PanneauBoutonsVerticauxLayout.setHorizontalGroup(
            PanneauBoutonsVerticauxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        PanneauBoutonsVerticauxLayout.setVerticalGroup(
            PanneauBoutonsVerticauxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );

        getContentPane().add(PanneauBoutonsVerticaux, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 60, 220));

        PanneauBoutonsHorizontaux.setBackground(new java.awt.Color(51, 117, 48));

        javax.swing.GroupLayout PanneauBoutonsHorizontauxLayout = new javax.swing.GroupLayout(PanneauBoutonsHorizontaux);
        PanneauBoutonsHorizontaux.setLayout(PanneauBoutonsHorizontauxLayout);
        PanneauBoutonsHorizontauxLayout.setHorizontalGroup(
            PanneauBoutonsHorizontauxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        PanneauBoutonsHorizontauxLayout.setVerticalGroup(
            PanneauBoutonsHorizontauxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        getContentPane().add(PanneauBoutonsHorizontaux, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 220, 60));

        PanneauAvancement.setMaximumSize(new java.awt.Dimension(367, 367));
        PanneauAvancement.setOpaque(false);
        PanneauAvancement.setPreferredSize(new java.awt.Dimension(60, 20));
        PanneauAvancement.setRequestFocusEnabled(false);

        jProgressBar1.setFont(new java.awt.Font("Annai MN", 0, 14)); // NOI18N
        jProgressBar1.setForeground(new java.awt.Color(0, 0, 0));
        jProgressBar1.setOrientation(1);
        jProgressBar1.setToolTipText("0,0");
        jProgressBar1.setStringPainted(true);

        javax.swing.GroupLayout PanneauAvancementLayout = new javax.swing.GroupLayout(PanneauAvancement);
        PanneauAvancement.setLayout(PanneauAvancementLayout);
        PanneauAvancementLayout.setHorizontalGroup(
            PanneauAvancementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanneauAvancementLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        PanneauAvancementLayout.setVerticalGroup(
            PanneauAvancementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanneauAvancementLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(PanneauAvancement, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 60, 220));

        diagoG.setBackground(new java.awt.Color(51, 117, 48));

        javax.swing.GroupLayout diagoGLayout = new javax.swing.GroupLayout(diagoG);
        diagoG.setLayout(diagoGLayout);
        diagoGLayout.setHorizontalGroup(
            diagoGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        diagoGLayout.setVerticalGroup(
            diagoGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        getContentPane().add(diagoG, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 60, 60));

        sapin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ChristmasTreePNG.png"))); // NOI18N
        sapin.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                sapinComponentResized(evt);
            }
        });
        getContentPane().add(sapin, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, -50, 870, 580));

        diagoD.setBackground(new java.awt.Color(51, 117, 48));

        javax.swing.GroupLayout diagoDLayout = new javax.swing.GroupLayout(diagoD);
        diagoD.setLayout(diagoDLayout);
        diagoDLayout.setHorizontalGroup(
            diagoDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        diagoDLayout.setVerticalGroup(
            diagoDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        getContentPane().add(diagoD, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 60, 60));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sapinComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_sapinComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_sapinComponentResized

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenetrePrincipale().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanneauAvancement;
    private javax.swing.JPanel PanneauBoutonsHorizontaux;
    private javax.swing.JPanel PanneauBoutonsVerticaux;
    private javax.swing.JPanel PanneauGrille;
    private javax.swing.JPanel diagoD;
    private javax.swing.JPanel diagoG;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel sapin;
    // End of variables declaration//GEN-END:variables
}
