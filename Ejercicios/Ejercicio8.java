package Ejercicios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class Ejercicio8 {
    public static void main(String[] args) {
        String fileIn = "D:\\Programación\\Java\\OpenBootcamp\\Ejercicios\\archivo1.txt";
        String fileOut = "D:\\Programación\\Java\\OpenBootcamp\\Ejercicios\\archivo2.txt";
        
        try {
            copiarArchivo(fileIn, fileOut);
            System.out.println("Archivo copiado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al copiar el archivo: " + e.getMessage());
        }
    }

    public static void copiarArchivo(String fileIn, String fileOut) throws IOException {
        InputStream inputStream = null;
        PrintStream printStream = null;

        try {
            inputStream = new FileInputStream(fileIn);
            printStream = new PrintStream(new FileOutputStream(fileOut));

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                printStream.write(buffer, 0, bytesRead);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (printStream != null) {
                printStream.close();
            }
        }
    }
}

