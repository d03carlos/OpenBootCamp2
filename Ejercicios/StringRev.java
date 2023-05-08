package Ejercicios;

public class StringRev {
    public static void main(String[] args) {
        String cadena = "Hola Mundo";
        for(int i = cadena.length()-1;i>=0;i--)
        {
            System.out.print(cadena.charAt(i));
        }
    }    
}
