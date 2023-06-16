package Ejercicios;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Coleccion1 {
    public static void main(String[] args) {
        List miLista = new ArrayList<>();
        ArrayList<String> miLista2 = new ArrayList<String>();
        miLista2.add("Alissa");
        miLista2.add("Dianna");
        miLista2.add("Svetlana");
        miLista.add("Hella");
        miLista.add("Jana");
        miLista.add("Alena");
        for(Object nombre:miLista){
            System.out.println(nombre);
        }
        for(String nombre2:miLista2){
            System.out.println(nombre2);
        }
    
    }
}
