package interfaces;

public class Principal {
    public static void main(String[] args) {
        AccesoDatos datos = new ImplementacionMysql();
        datos.insertar();
        datos.listar();
        AccesoDatos datos2 = new ImplementacionOracle();
        datos2.insertar();
        datos2.listar();
    }
}
