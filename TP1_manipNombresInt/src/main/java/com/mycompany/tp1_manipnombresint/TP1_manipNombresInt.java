/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.tp1_manipnombresint;

/**
 *
 * @author Arthur
 */


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Saisie de deux entiers
        System.out.print("Veuillez saisir le premier entier : ");
        int nombre1 = scanner.nextInt();

        System.out.print("Veuillez saisir le deuxième entier : ");
        int nombre2 = scanner.nextInt();

        // Affichage des résultats
        System.out.println("Somme : " + (nombre1 + nombre2));
        System.out.println("Différence : " + (nombre1 - nombre2));
        System.out.println("Produit : " + (nombre1 * nombre2));
        System.out.println("Quotient : " + (nombre1 / nombre2));
        System.out.println("Reste : " + (nombre1 % nombre2));
    }
}
