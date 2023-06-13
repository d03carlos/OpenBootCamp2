import java.util.Scanner;

public class OpeMat {
      public static void main(String[] args) {
        
        System.out.println(sumar(3.55d,5.3d));
        System.out.println(restar(5.5f,3.0f));
        System.out.println(multiplicar(5,5));
        System.out.println(dividir(5,5));
    } 

    //funcion suma
    public static int sumar(int a, int b){
        return a+b;
    }
    public static float sumar(float a, float b){
        return a+b;
    }
    //funcion resta
    public static int restar(int a, int b){
        return a-b;
    }
    public static float restar(float a, float b){

            return a-b;
        }
    //funcion multiplicar
    public static int multiplicar(int a, int b){
        return a*b;
    }
    public static float multiplicar(float a, float b){
        return a*b;
    }
    //funcion dividir 
    public static int dividir(int a, int b){
        if(b==0){
            return 0;
        }
        else
        {
            return a/b;
        }
    }
    public static float dividri(int a, int b){
        if(b==0){
            return 0;
        }
        else
        {
            return a/b;
        }
    }
}    







