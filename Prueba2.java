import java.util.function.Function;

public class Prueba2 {

    private Function<String, String> toMayus = (String s) -> s.toUpperCase();

    /*public String mayusculas(String s) {
        return toMayus.apply(s);
    }*/
    public static void main(String[] args) {
        Prueba2 p = new Prueba2();
        System.out.println(p.toMayus.apply("Maria"));
        System.out.println(p.toMayus.apply("Hella"));
        System.out.println(p.toMayus.apply("Diana"));
    }
}
