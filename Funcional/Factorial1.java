package Funcional;

import java.util.stream.IntStream;

public class Factorial1 {
    public static void main(String[] args) {
        System.out.println(factorialRecursivo(5));
        System.out.println(factorialFuncional(5));
    
    }
    public static int factorialRecursivo(int numero) {
        return numero == 0 ? 1 :numero *factorialRecursivo(numero-1);
        /*if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
        */
    }
    public static int factorialFuncional(int numero) {
        return numero == 0 ? 1 : IntStream.rangeClosed(1, numero).reduce(1, (x, y) -> x * y);
    }
}
