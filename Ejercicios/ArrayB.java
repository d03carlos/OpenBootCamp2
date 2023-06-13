package Ejercicios;
/*
 * Se aplica el patro iterator
 * Este patron es adecuado para lograr el objetivo específico del código, que es imprimir las combinaciones de elementos de ambos arreglos.
 */
public class ArrayB {
    public static void main(String[] args) {
        int[] numeros1 ={1,2,3,4,5};
        int[] numeros2 ={6,7,8,9,10};
        
        for(int i=0;i<numeros1.length;i++){
            for(int j=0;j<numeros2.length;j++){
                System.out.println("("+i+","+j+")"+numeros1[i]+","+numeros2[j]);
            }
            System.out.println("------------");
        }

    }
}
