
import java.util.InputMismatchException;
import java.util.Scanner;
public class ScannerE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese un numero entero:");
        int numero=0;
        while(true){
            try{
                numero=sc.nextInt();
                break;
            }catch(InputMismatchException e){
                System.out.println("No es un numero entero");
                System.out.println("Ingrese un numero entero:");
                sc.next();
            }
        }
        System.out.println("El numero es: "+numero);
        sc.close();
    }  
}  
     
/* utilizando boolean
 import java.util.InputMismatchException;
import java.util.Scanner;
public class ScannerE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese un numero entero:");
        int numero=0;
        boolean esnumero=false;
        while(esnumero==false){
            try{
                numero=sc.nextInt();
                esnumero=true;
                
            }catch(InputMismatchException e){
                System.out.println("No es un numero entero");
                System.out.println("Ingrese un numero entero:");
                sc.next();
            }
        }
        System.out.println("El numero es: "+numero);
        sc.close();
    }  
}  
     

 */





