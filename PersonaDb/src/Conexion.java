import java.sql.Connection;
import java.sql.DriverManager;
public class Conexion {
    private static final String URL="jdbc:mysql://localhost:3306/prueba";
    private static final String USERNAME="fidel";
    private static final String PASSWORD="456jenifer456a";
    
    public static Connection getConnection(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }catch(Exception e){
            System.out.println(e);
        }
        return con;
    }
    
}
