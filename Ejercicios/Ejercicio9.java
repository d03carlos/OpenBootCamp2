package Ejercicios;
import java.util.*;

public class Ejercicio9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> employeeData = new HashMap<>();
        List<String> employeeList = new ArrayList<>();

        try {
            boolean running = true;
            while (running) {
                System.out.println("Ingrese el nombre del empleado ('salir' para terminar):");
                String name = scanner.nextLine();
                if (name.equalsIgnoreCase("salir")) {
                    running = false;
                    break;
                }

                System.out.println("Ingrese el puesto del empleado:");
                String position = scanner.nextLine();

                employeeData.put(name, position);
                employeeList.add(name);

                System.out.println("¡Empleado agregado exitosamente!");
                System.out.println();
            }

            Collections.sort(employeeList);

            System.out.println("Lista de empleados:");
            for (String employee : employeeList) {
                System.out.println(employee + ": " + employeeData.get(employee));
            }
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

