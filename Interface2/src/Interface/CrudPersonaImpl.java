package Interface;

public class CrudPersonaImpl implements CrudPersona{
    @Override
    public void agregar() {
        System.out.println("Agregar");
    }

    @Override
    public void listar() {
        System.out.println("Listar");
    }

    @Override
    public void eliminar(){
        System.out.println("Eliminar");
    }
}
