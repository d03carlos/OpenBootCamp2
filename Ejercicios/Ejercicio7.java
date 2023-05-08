package Ejercicios;

public class Ejercicio7 {
    public static void main(String[] args) {
    try{
        
        System.out.println(DividirPorCero(11,6));
    }
    catch(ArithmeticException e){
        System.out.println("Esto no puede hacerse");  
    }
    finally{
        System.out.println("Demo codigo");
    }
}
    public static float DividirPorCero(float a, float b) throws ArithmeticException{
        if(b == 0){
            throw new ArithmeticException();
        } 
        return a/b;
    }
}  

