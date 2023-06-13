import java.util.Scanner;
public class Nombres {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombre;
        String asterisco="*";
        //pedimos al usuario que ingrese su nombre
        System.out.println("Ingrese su nombre: ");
        //guardamos el nombre en la variable 
        nombre = sc.nextLine();
        //mostramos el mensaje
        for (int i = 0; i < nombre.length()+1; i++){
            //System.out.print(asterisco);
            asterisco += "*";
            //System.out.println();
        
        }
        System.out.println(asterisco);
        System.out.println("*" + nombre + "*");
        System.out.println(asterisco);
    }
}
