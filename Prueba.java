

public class Prueba {
    public static void main(String[] args) {
        Funcionales p = new Funcionales();
        System.out.println(p.toMayus.apply("hola"));
        System.out.println(p.toMayus2.apply("hola"));
        System.out.println(p.toMayus.andThen(p.toMayus2).apply("hola"));
        System.out.println(p.toMayus.compose(p.toMayus2).apply("hola"));
        System.out.println(p.toMayus.andThen(p.toMayus2).andThen(p.toMayus2).apply("hola"));
        System.out.println(p.toMayus.compose(p.toMayus2).compose(p.toMayus2).apply("hola"));
        System.out.println(p.toMayus.compose(p.toMayus2).andThen(p.toMayus2).apply("hola"));
    }
}
