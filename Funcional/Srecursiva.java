package Funcional;

import java.util.stream.IntStream;

public class Srecursiva {
    public static void main(String[] args) {
        /*
         * int n = 5;
         * int resultado = fatorial(n);
         * System.out.println(resultado);
         * }
         * public static int fatorial(int n){
         * if(n == 1){
         * return 1;
         * }else{
         * return n * fatorial(n-1);
         * }
         * }
         */
        int resultado = sumaRecursiva(5);
        System.out.println(resultado);
        int resultado2 = fatorial(8);
        System.out.println(resultado2);
        System.out.println(fibonacci(10));
        System.out.println(suma2(10));
    }

    public static int sumaRecursiva(int numero) {
        // utilizamos el operador condicional ternario (? :)
        // para realizar una verificación. Si numero es igual a 0,
        // devuelve 0, lo cual es el caso base de la recursión
        return numero == 0 ? 0 : numero + sumaRecursiva(numero - 1);
        /*
         * if(numero == 0){
         * return 0;
         * }
         * System.out.println(numero);
         * return numero+sumaRecursiva(numero-1);
         */
    }

    public static int fatorial(int numero) {
        //System.out.println(numero);
        //return numero == 0 ? 1 : numero * fatorial(numero - 1);
        if (numero == 0) {
            return 1;
        }
        return numero * fatorial(numero - 1);
    }
    
    public static int fibonacci(int numero){
        if(numero == 0){
            return 0;
        }
        if(numero == 1){
            return 1;
        }
        return fibonacci(numero-1) + fibonacci(numero-2);
        //System.out.println(numero);    
    }
    
    public static int suma2(int numero){
        return IntStream.range(1, 10).reduce(0, (a,b) -> a+b);
    }
}
