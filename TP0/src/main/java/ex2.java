/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;

/**
 *
 * @author Arthur
 */
public class ex2 {
    /**
     *
     * @param args
     */

        
public static void main(String[] args) {
    int nb;
    
//nb=5;
Scanner sc = new Scanner(System.in);
System.out.println("\n Entrer le nombre :");
nb=sc.nextInt(); // On demande a sc de donner le prochain entier
    int result; // resultat
    int ind; //indice
    result = 0;
             // Addition des nb premiers entiers
    ind=1;
    while (ind <= nb) {
         result=result+ind;
         ind++;
    }
             // Affichage du resultat
    System.out.println();
    System.out.println("La somme des "+ nb + "entiers est: "+result);
}
}
    

