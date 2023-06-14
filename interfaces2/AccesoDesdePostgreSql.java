package interfaces2;

public class AccesoDesdePostgreSql implements AccesoDatos{
    @Override
    public void insertar(){
        System.out.println("Insertar desde PostgreSql");
    }
    public void listar(){
        System.out.println("Listar desde PostgreSql");
    }
}
