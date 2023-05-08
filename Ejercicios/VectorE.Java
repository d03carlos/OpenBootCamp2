package Ejercicios;
import java.util.Vector;
public class VectorE{
    public static void main(String[] args) {
        Vector <String> vector = new Vector<String>();
        vector.add("Hella");
        vector.add("Alena");
        vector.add("Svetlana");
        vector.add("Alena");
        vector.add("Jana");
        System.out.println(vector);
        vector.remove(2);
        vector.remove(3);
        System.out.println(vector);
    }
}