public class App {
    public static void main(String[] args) throws Exception {
       Persona p = new Persona();
       p.setNombre("Julia Doga");
       p.setEdad(19); 
       CrudPersona cp = new CrudPersona();
       String respuesta = cp.ingresarPersona(p).equals("ok") ? "Se ingreso correctamente" : "No se pudo ingresar";
       System.out.println(respuesta);    
       cp.listarPersonas();
       //cp.eliminarPersona(6);
    }
}
