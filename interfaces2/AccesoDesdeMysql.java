package interfaces2;

public class AccesoDesdeMysql implements AccesoDatos{
    @Override
    public void insertar(){
        System.out.println("Insertar desde Mysql");
    }
    public void listar(){
        System.out.println("Listar desde Mysql");
    }
    
}
