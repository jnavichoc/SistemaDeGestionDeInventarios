/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectsistemagestiondeinventarios;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author jacqu
 */
public class ProyectSistemaGestionDeInventarios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);
        
        int opcion;
        String pw;
        File passwordFile = new File ("contraseña.txt");
       /* if (passWord.exists()){
            System.out.println("El archivo existe");
            }
        else {System.out.println("No existe");
        } */
        
        //Ingreso al Sistema
        System.out.println("SISTEMA DE GESTION DE INVENTARIOS\n");

        //Creacion del menú principal
        System.out.println("1. Gestion de Productos");
        System.out.println("2. Control de Existencias");
        System.out.println("3. Pedidos de Compra");
        System.out.println("4. Informes y Estadisticas");
        System.out.println("Seleccione una opcion: ");
        opcion = entrada.nextInt();
        
        switch (opcion) {
            case 1: System.out.println("Ingrese Contraseña (admin):");
                   
            
        
        }
        
      
        
    }  
}   

