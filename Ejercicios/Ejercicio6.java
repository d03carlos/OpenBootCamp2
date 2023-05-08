package Ejercicios;

import java.util.ArrayList;

public class Ejercicio6 {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        for(int i = 1; i <= 10; i++){
            lista.add(i);
        }
        for(int i=lista.size()-1;i>0;i--){
            if(lista.get(i)%2==0){
                lista.remove(i);
            }
        }
        for(int lista2:lista){
            System.out.println(lista2);
        }
    }
}
