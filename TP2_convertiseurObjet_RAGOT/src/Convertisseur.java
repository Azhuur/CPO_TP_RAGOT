/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Arthur
 */
public class Convertisseur {
        public static void main(String[] args) {
          Convertisseur convertisseur1 = new Convertisseur();
          Convertisseur convertisseur2 = new Convertisseur();

        System.out.println("Convertisseur 1 :");
        System.out.println("30°C en Kelvin : " + convertisseur1.celciusVersKelvin(30));
        System.out.println("300 K en Celcius : " + convertisseur1.kelvinVersCelcius(300));
        System.out.println("40°C en Fahrenheit : " + convertisseur1.celciusVersFahrenheit(40));
        System.out.println("104°F en Celcius : " + convertisseur1.fahrenheitVersCelcius(104));
        System.out.println(convertisseur1);

        System.out.println("\nConvertisseur 2 :");
        System.out.println("20°C en Kelvin : " + convertisseur2.celciusVersKelvin(20));
        System.out.println("250 K en Celcius : " + convertisseur2.kelvinVersCelcius(250));
        System.out.println("10°C en Fahrenheit : " + convertisseur2.celciusVersFahrenheit(10));
        System.out.println("50°F en Celcius : " + convertisseur2.fahrenheitVersCelcius(50));
        System.out.println(convertisseur2);
    }

    private String kelvinVersCelcius(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String celciusVersKelvin(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
public class Convertisseur {
    private int nbConversions;

    public Convertisseur() {
        nbConversions = 0;
    }

    public double celciusVersKelvin(double degreCelcius) {
        nbConversions++;
        return degreCelcius + 273.15;
    }

    public double kelvinVersCelcius(double degreKelvin) {
        nbConversions++;
        return degreKelvin - 273.15;
    }

    public double celciusVersFahrenheit(double degreCelcius) {
        nbConversions++;
        return (degreCelcius * 9 / 5) + 32;
    }

    public double fahrenheitVersCelcius(double degreFahrenheit) {
        nbConversions++;
        return (degreFahrenheit - 32) * 5 / 9;
    }

    public int getNbConversions() {
        return nbConversions;
    }

    @Override
    public String toString() {
        return "Nombre de conversions : " + nbConversions;
    }
}    

