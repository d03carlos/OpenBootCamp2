package interfaces2;

public class Principal {
    public static void main(String[] args) {
        AccesoDatos datos = new AccesoDesdePostgreSql();
        datos.insertar();
        datos.listar();
        AccesoDatos datos2 = new AccesoDesdeMysql();
        datos2.insertar();
        datos2.listar();
    }
}
