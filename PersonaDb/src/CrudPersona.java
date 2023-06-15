import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
//import com.mysql.cj.jdbc.CallableStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;

public class CrudPersona {
    CallableStatement cs = null;
    Conexion con = new Conexion();
    Connection cn = null;
    ResultSet rs = null;

    public String ingresarPersona(Persona p) {
        String respuesta = "";
        try {
            cn = con.getConnection();
            cs = cn.prepareCall("Call ingresarPersona(?, ?)");
            cs.setString(1, p.getNombre());
            cs.setInt(2, p.getEdad());
            int resp = cs.executeUpdate();
            if (resp > 0) {
                respuesta = "ok";
            } else {
                respuesta = "";
            }
            cs.close();
            cn.close();
        } catch (Exception ex) {
            System.out.println("Error al ingresar persona en.." + ex.getMessage());
        }
        return respuesta;
    }

    public void listarPersonas() {
        try {
            cn = con.getConnection();
            cs = cn.prepareCall("call listarPersona()");
            //cs.setString(1, nom);
            rs = cs.executeQuery();
            while (rs.next()) {
                int id = Integer.valueOf(rs.getInt(1));
                String nombre = rs.getString(2).toString();
                int edad = rs.getInt(3);
                System.out.println("id: " + id + " nombre: " + nombre + " edad: " + edad);
            }
            rs.close();
            cs.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Error al listar personas en.." + e.getMessage());
        }
    }

    public void eliminarPersona(int id) {
        try {
            cn = con.getConnection();
            cs = cn.prepareCall("call eliminarPersona(?)");
            cs.setInt(1, id);
            int resp = cs.executeUpdate();
            if (resp > 0) {
                System.out.println("Persona eliminada");
            }
            cs.close();
            cn.close();
        }
        catch (Exception e) {
            System.out.println("Error al eliminar persona en.." + e.getMessage());
        }
    }
}
