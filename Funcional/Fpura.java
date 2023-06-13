package Funcional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;
public class Fpura {
    
    public static void main(String[] args) {
        Funcionales f =  new Funcionales();
        //System.out.println(f.toMayus.apply("Hella"));
        //System.out.println(f.cuadrado.apply(5));
        //Saluda s = new Saluda();
        //System.out.println(s.Saluda(f.toMayus, "Hella"));
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Hella");
        nombres.add("Yulia");
        nombres.add("Sveltana");
        nombres.add("Dianna");
        nombres.stream().map(x->x.toUpperCase()).filter(x->x.contains("H")).forEach(System.out::println);
        int[] numeros = {1,2,3,4,5,6,7,8,9,10};
        var numerosStream = Arrays.stream(numeros);
        // Stream<Integer> numerosStream = Arrays.stream(numeros);
        var numerosPares = numerosStream.filter(x->x%2==0).reduce(0, (x,y)->x+y);
        //numerosPares.forEach(System.out::println);
        // numerosStream.forEach(System.out::println);
       System.out.println(numerosPares);
    }
}
class Funcionales{
    public Function<String, String> toMayus = (x->x.toUpperCase());
    public Function<Integer, Integer> cuadrado = (x->x*x);
}
class Saluda{
    public String Saluda(Function<String, String> miFuncion, String nombre){
       return miFuncion.apply(nombre);
    }
}
