import java.security.PublicKey;

public class Persona {
    private int id_persona;
    private String nombre;
    private int edad;

    public int getIdpersona(){
        return id_persona;
    }
    public void setIdPersona(int id){
        this.id_persona = id;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public int getEdad(){
        return edad;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
}
