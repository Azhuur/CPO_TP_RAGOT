/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.tp1_convertisseur;

/**
 *
 * @author Arthur
 */
import java.util.Scanner;

public class TP1_convertisseur {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bonjour, saisissez une valeur : ");
        double temperature = scanner.nextDouble();

        System.out.println("Saisissez la conversion que vous souhaitez effectuer :");
        System.out.println("1) De Celcius vers Kelvin");
        System.out.println("2) De Kelvin vers Celcius");
        System.out.println("3) De Farenheit vers Celcius");
        System.out.println("4) De Celcius vers Farenheit");
        System.out.println("5) De Kelvin vers Farenheit");
        System.out.println("6) De Farenheit vers Kelvin");
 temp = 0       
 int choix = scanner.nextInt();

        double result = 0;

        switch (choix) {
            case 1:
                result = temp + 273,15;
                
            case 2:
                result = temp + 273,15;
               
            case 3:
                result = temp - 273,15;
                
            case 4:
                result = temp + 273,15;
                
            case 5:
                result = temp - 273,15;
                
            case 6:
                result = ;
                
        }
    }
    
