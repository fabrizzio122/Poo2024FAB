/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.poo.claseinterna;

/**
 *
 * @author Datos
 */
public class Principal {
    public static void main(String[] args) {
        Mom objM=new Mom();
        objM.alimentar();
        Mom.Bebe bb=objM.new Bebe();
        bb.moverse();
    }
}
