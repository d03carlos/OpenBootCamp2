package Ejercicios;

import java.util.Scanner;
import java.util.logging.Logger;

public class EentardaS {
    private static final Logger LOGGER = Logger.getLogger(EentardaS.class.getName());
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //declaramos nuestras varibales locales
        int edad;
        String nombre;
        //pedimos al usiario que ingrese el nombre
        LOGGER.info("Ingrese su nombre: ");
        //obtenemos el nombre y lo almacenamos en la varibale nombre
        nombre = sc.nextLine();
        //pedimos al usuario que ingrese la edad
        LOGGER.info("Ingrese su edad: ");
        //obtenemos la edad y la almacenamos en la varibale edad
        edad = sc.nextInt();
        sc.close();
        //mostramos por pantalla el nombre y la edad
        LOGGER.info("Su nombre es: " + nombre + " y su edad es: " + edad);
    }
}
