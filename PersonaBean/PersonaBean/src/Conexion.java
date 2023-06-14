import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/colegio";
    private static final String USER = "root";
    private static final String PASSWORD = "";
   
    private Connection connection;
    
    public Conexion() {
        try {
            // Registrar el controlador JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void conectar() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("Conexión exitosa a la base de datos");
    }

    public void desconectar() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("Desconexión exitosa de la base de datos");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        try {
            conexion.conectar();
            // Realizar operaciones con la base de datos
            // ...
            //conexion.desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

