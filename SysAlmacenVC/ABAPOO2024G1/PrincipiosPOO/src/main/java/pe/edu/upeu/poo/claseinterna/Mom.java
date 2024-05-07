/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.poo.claseinterna;

/**
 *
 * @author Datos
 */
public class Mom {
    String alimento = "Nutrientes";
    public void alimentar() {
        System.out.println("Alimenta dando " + alimento);
    }
    class Bebe {
        double peso = 1;
        public void moverse(){
            System.out.println("Da pataditas..");
        }
    }
}
