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
        File categorias = new File ("categorias.txt");
       
        //verificacion de la existencia del archivo
        /*if (categorias.exists()){
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
            case 1: System.out.println("GESTION DE PRODUCTOS\nIngrese Contraseña (admin):");
                   pw = entrada.next();
               
                   if ("admin246".equals(pw)){  
                        System.out.println("Categorias de Productos\n");
                        System.out.println("1. Categorias Existentes");
                        System.out.println("2. Agregar Nueva Categoria");
                        System.out.println("3. Modificar Categoria");
                        System.out.println("4. Eliminar Categoria"); 
                        System.out.println("5. Salir");
                        System.out.println("Seleccione una opcion:");
                 
                        opcion = entrada.nextInt();
                        switch (opcion){
                            case 1: 
                                System.out.println();
                                break;
                            case 2:
                                
                                break;
                            case 3:
                                    
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Opcion Invalida");
                        }
                   }
                   else {System.out.println("Contraseña Incorrecta, intente de nuevo o ingrese 0 para regresar:");
                       pw = entrada.next();}
  
                   break;
                   
            case 2: System.out.println("CONTROL DE EXISTENCIAS\n");
                    System.out.println("");
        }
        
      
        
    }  
}   

