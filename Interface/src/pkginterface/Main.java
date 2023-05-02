/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkginterface;

/**
 *
 * @author FIDEL LAURA
 */
public class Main {
    public static void main(String[] args){
        CocheCrud cocheCrud = new CocheCRUDImpl();
        cocheCrud.save();
        cocheCrud.findAll();
        cocheCrud.delete();
    }
}
