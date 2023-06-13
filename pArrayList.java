import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class pArrayList {
    public static void main(String[] args) {
        ArrayList<String>lista = new ArrayList<>();
        lista.add("Jana");
        lista.add("Hella");
        lista.add("Svetlana");
        lista.add("Alena");
        
        //Stream<String>stream = lista.stream();
        Stream<String>stream2 = lista.stream().map(x->x
        .toUpperCase()).filter(x->x.startsWith("H"));
        
        //lista.stream().forEach(System.out::println);
        stream2.forEach(System.out::println);

        int[] numeros = {1,2,3,4,5,6,7,8,9,10};
        var stNumeros = Arrays.stream(numeros);
        var resultado = stNumeros.filter(x->x%2==0).reduce(0, (x,y)->x+y);
        //stNumeros.forEach(System.out::println);
        //resultado.forEach(System.out::println);
        System.out.println("Mi suma de pares es: "+resultado);
    }
}
