package Java.cocheCrud;

public class Main {
    public static void main(String[] args){
        CocheCrud cocheCrud = new CocheCRUDImpl();
        cocheCrud.save();
        cocheCrud.findAll();
        cocheCrud.delete();
    }
    
}
