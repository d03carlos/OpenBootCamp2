package Java.Persona;

public class CrudPersonaImpl implements CrudPersona {
    @Override
    public void crear() {
        System.out.println("Guardar");
    }
    @Override
    public  void leer() {
        System.out.println("Leer");
    }
    @Override
    public void eliminar(){
        System.out.println("Eliminar");
    }
}