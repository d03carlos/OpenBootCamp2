class Ejercicio4 {
    public static void main(String[] args) {
        SmartPhone iphone = new SmartPhone("X", "Apple", 128, "IOS", "72h");
        SmartWatch watch  = new SmartWatch("A1", "Huawei", 64, "Bluetooh", "si");
        
        System.out.println("Smartphone, "+"Modelo: "+iphone.getModelo()+"Marca:  "+iphone.getMarca()+"Almacenamiento: "+iphone.getCapacidadAlmacenamiento()+"Sistema Operativo: "+iphone.getSistemaOperativo()+"Duracion de Bateria: "+iphone.getDuracionBateria());
        System.out.println("Reloj inteligente: "+"Modelo: "+watch.getModelo()+"Marca: "+watch.getMarca()+"Almacenamiento: "+watch.getCapacidadAlmacenamiento()+"Conectividad: "+watch.getConectividad()+"Sensor cardiaco:"+watch.getSensonRitmoCardiaco());
    }
}
class SmartDevice{
    private String modelo;
    private String marca;
    private int capacidadAlmacenamiento;

    public SmartDevice(){
    }
    public SmartDevice(String modelo, String marca, int capacidadAlmacenamiento){
        this.modelo = modelo;
        this.marca = marca;
        this.capacidadAlmacenamiento = capacidadAlmacenamiento;
    }
    public String getModelo(){
        return modelo;
    }
    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public String getMarca(){
        return marca;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }

    public int getCapacidadAlmacenamiento(){
        return  capacidadAlmacenamiento;
    }
    public  void setCapacidadAlmacenamiento(int capacidadAlmacenamiento){
        this.capacidadAlmacenamiento = capacidadAlmacenamiento;
    }
}

class SmartPhone extends SmartDevice{
    private String sistemaOperativo;
    private String duracionBateria;
    public SmartPhone(){
    }
    public SmartPhone(String modelo, String marca, int capacidadAlmacenamiento, String sistemaOperativo, String duracionBateria){
        super(modelo, marca, capacidadAlmacenamiento);
        this.sistemaOperativo = sistemaOperativo;
        this.duracionBateria = duracionBateria;
    }

    public String getSistemaOperativo(){
        return sistemaOperativo;
    }
    public void setCapacidadAlmacenamiento(String sistemaOperativo){
        this.sistemaOperativo = sistemaOperativo;
    }

    public String getDuracionBateria(){
        return duracionBateria;
    }

    public void setDuracionBateria(String duracionBateria){
        this.duracionBateria = duracionBateria;
    }
}

class SmartWatch extends SmartDevice{
    private String conectividad;
    private  String sensonRitmoCardiaco;
    public SmartWatch(){
    }
    public SmartWatch(String modelo, String marca, int capacidadAlmacenamiento, String conectividad, String sensonRitmoCardiaco){
        super(modelo, marca, capacidadAlmacenamiento);
        this.conectividad = conectividad;
        this.sensonRitmoCardiaco = sensonRitmoCardiaco;
    }

    public String getConectividad(){
        return conectividad;
    }
    public String getSensonRitmoCardiaco(){
        return sensonRitmoCardiaco;
    }

    public void setConectividad(String conectividad){
        this.conectividad = conectividad;
    }
    public void setSensonRitmoCardiaco(String sensonRitmoCardiaco){
        this.sensonRitmoCardiaco = sensonRitmoCardiaco;
    }
}