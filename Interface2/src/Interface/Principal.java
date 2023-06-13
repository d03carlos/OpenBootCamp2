package Interface;

public class Principal {
    public static void main(String[] args) {
        CrudPersona crudPersona = new CrudPersonaImpl();
        crudPersona.agregar();
        crudPersona.listar();
        crudPersona.eliminar();
    }

}
