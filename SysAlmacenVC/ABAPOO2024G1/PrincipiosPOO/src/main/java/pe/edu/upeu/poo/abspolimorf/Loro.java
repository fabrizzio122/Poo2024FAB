/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.poo.abspolimorf;

/**
 *
 * @author Datos
 */
public class Loro extends Animal{
    @Override
    public void animalSound() {
        System.out.println("Hola manito");
    }
   // public void sleep() {
      //  System.out.println("Estoy durmiendo");
   // }
    @Override
    public void sleep(){
        System.out.println("No me molestes... estoy durmiendo");
        
    }
}
