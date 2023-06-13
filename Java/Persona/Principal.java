package Java.Persona;

public class Principal {
    public static void main(String[] args) {
        CrudPersona crudPersona = new CrudPersonaImpl();
        crudPersona.crear();
        crudPersona.leer();
        crudPersona.eliminar();    
}
