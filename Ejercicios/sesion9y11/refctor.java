package Ejercicios.sesion9y11;

public class refctor {
    public static void main(String[] args) {
        try {
            System.out.println(dividirPorCero(11, 6));
        } catch (ArithmeticException e) {
            System.out.println("No se puede dividir por cero");
        } finally {
            System.out.println("Demo código");
        }
    }

    public static float dividirPorCero(float a, float b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("División por cero");
        }
        return a / b;
    }
}
