public class App {
    public static void main(String[] args) throws Exception {
        PersonaBean persona = new PersonaBean();
        persona.setNombre("Hella");
        persona.setEdad(20);
        System.out.println("Nombre: "+persona.getNombre());
        System.out.println("Edad: "+persona.getEdad());
    }
}
