/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Arthur
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetreRegles extends JDialog {

    // Ajoutez une référence à la fenêtre principale
    public FenetreRegles(JFrame parent, JFrame fenetrePrincipale) {
        super(parent, "Bienvenue !", true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Ajoutez ici le texte des règles
        JTextArea reglesText = new JTextArea("""
                                             Bienvenue sur le jeu qui te permettra de faire passer le temps plus vite lors des repas de No\u00ebl interminables ;)
                                             
                                             
                                             Les r\u00e8gles du jeu sont les suivantes : Une grille de cellules (allumées/éteintes) est génerée aléatoirement
                                             le but du jeu : eteindre toutes les cellules pour remporter la partie en utilisant les boutons repr\u00e9sentant 
                                             les lignes, les colonnes, et les diagonales !
                                             
                                             
                                             (TIPS de pro: Jette un \u0153il \u00e0 la barre de progression, elle te permettra de conna\u00eetre en temps r\u00e9el le pourcentage de cellules \u00e9teintes ! )""");

        reglesText.setEditable(false);

        add(reglesText, BorderLayout.CENTER);

        // Ajoutez le bouton "JOUER"
        JButton jouerButton = new JButton("JOUER");
        jouerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fermer la fenêtre de règles
                // Afficher à nouveau la fenêtre principale
                fenetrePrincipale.setVisible(true);
            }
        });

        add(jouerButton, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(parent);
    }
}
