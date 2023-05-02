/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkginterface;

/**
 *
 * @author FIDEL LAURA
 */
public class CocheCRUDImpl implements CocheCrud{

    @Override
    public void save() {
        System.out.println("llamado al metodo save()");
    }

    @Override
    public void findAll() {
        System.out.println("llamado al metodo findAll()");
    }

    @Override
    public void delete() {
        System.out.println("llamado al metodo delete()");
    }
    
}
