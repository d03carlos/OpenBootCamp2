package Ejercicios;

import java.util.ArrayList;
import java.util.LinkedList;

public class EjemploArrayList {
    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<String>(4);
        
        lista.add("Yulia");
        lista.add("Alissa");
        lista.add("Dianna");
        lista.add("Svetlana");
        //copiamos el ArrayList a un LinkedList
        LinkedList<String> linkedLista = new LinkedList<String>(lista);
        //Reccorremos el ArrayList y mostramos únicamente el valor
        System.out.println("Recorrer ArrayList");
        for (String nombre : lista) {
            System.out.println(nombre);
        }
        //Reccorremos el LinkedList y mostramos únicamente el valor
        System.out.println("------------------");
        System.out.println("Recorrer LinkedList");
        for (String nombre : linkedLista) 
        {
            System.out.println(nombre);
        } 
    }
}
