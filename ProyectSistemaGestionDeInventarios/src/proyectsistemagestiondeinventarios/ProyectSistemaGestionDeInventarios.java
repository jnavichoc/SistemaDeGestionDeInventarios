/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectsistemagestiondeinventarios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author jacqu
 * @author  Jaquelin Navichoc
 */
public class ProyectSistemaGestionDeInventarios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);  
        
        //Creacion de archivos que se utlizaran para almacenar informacion 
        File actvdUsuariosFile = new File("ActividadDeUsuarios.txt");
        File categoriasFile = new File ("Categorias.txt");
        File pwFile = new File ("pwSistema.txt");
        File pwAdminFile = new File ("pwAdmin.txt");
        File specifacionesFile = new File ("Especificaciones.txt");
        File productosFile = new File ("Productos.txt");
        
       // Comprobacion de la existencia de los archivos
        /*String ruta = ".\\src\\proyectsistemagestiondeinventarios\\Especificaciones.txt"; 
        File archivo = new File(ruta);

        if (archivo.exists()) {
            System.out.println("El archivo existe.");
        } else {
            System.out.println("El archivo no existe.");
        } */
        
        //Ingreso al Sistema con contraseña, 
        //el código intenta leer una contraseña desde un archivo y manejar posibles errores durante la operación.
        String Ruta = ".\\src\\proyectsistemagestiondeinventarios\\pwSistema.txt"; 
        String pw ="";
        try {
            System.out.println("BIENVENIDO AL SISTEMA DE GESTION DE INVENTARIOS\n ");
            FileReader pwFileReader = new FileReader(Ruta);
            BufferedReader pwBufferedReader = new BufferedReader(pwFileReader);
            pw = pwBufferedReader.readLine();
            pwBufferedReader.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
   
        do {
            System.out.println("Por favor ingrese la contraseña del sistema: ");
            String pwSistema;
            pwSistema = entrada.nextLine();

            if (pwSistema.equals(pw)) {
                System.out.println("Contraseña Correcta\n");
                MenuPrincipal();

            } else {
                System.out.println("Contrasela Incorrecta, vuelve a intentar: ");
            }
        } while (true);
    }

 
    //Creacion del menú principal
    public static void MenuPrincipal() {
        Scanner entrada = new Scanner(System.in);
        int opcion;

        System.out.println("---------------MENU PRINCIPAL---------------------\n");
        System.out.println("1. Gestion de Productos");
        System.out.println("2. Control de Existencias");
        System.out.println("3. Pedidos de Compra");
        System.out.println("4. Informes y Estadisticas");
        System.out.println("Seleccione una opcion: ");
        opcion = entrada.nextInt();
        
        switch (opcion){
            case 1: //Gestion de Productos, se requiere contraseña del Administrador
                ContrasGestionDeProductos ();
                break;
                
            case 2: //Control de existencias
               
                break;
                
            case 3://pedidos de compra
                
                break;
                
            case 4://informes y estadisticas
                
                break;
            default: 
                System.out.println("Ingrese una opcion valida");
            }
        }
    
    
//--------GESTION DE PRODUCTOS---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void ContrasGestionDeProductos (){
        Scanner entrada = new Scanner(System.in);
        String Ruta = ".\\src\\proyectsistemagestiondeinventarios\\pwAdmin.txt"; 
        String pw ="";
        try {
            System.out.println("---------------GESTION DE PRODUCTOS---------------\n ");
            System.out.println("Se requiere rol de Administrador");
            FileReader pwFileReader = new FileReader(Ruta);
            BufferedReader pwBufferedReader = new BufferedReader(pwFileReader);
            pw = pwBufferedReader.readLine();
            pwBufferedReader.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
   
        do {
            System.out.println("Por favor ingrese contraseña de Administrador: ");
            String pwAdmin;
            pwAdmin = entrada.nextLine();

            if (pwAdmin.equals(pw)) {
                System.out.println("Contraseña Correcta\n");
                MenuGestionDeProductos();

            } else {
                System.out.println("Contraseña Incorrecta ");
            }
        } while (true);
    } //Fin Metodo ContrasGestionDeProductos
    
    
    
        public static void MenuGestionDeProductos (){
            Scanner entrada = new Scanner(System.in);
            File categoriasFile = new File ("Categorias.txt");
            String categorias = ".\\src\\proyectsistemagestiondeinventarios\\Categorias.txt";
            String nomNewCategoria="";
            int opcion;
            
            System.out.println("1. Categorias Existentes");
            System.out.println("2. Agregar Nueva Categoria");
            System.out.println("3. Modificar Categoria");
            System.out.println("4. Eliminar Categoria Existente");
            System.out.println("5. Productos");
            System.out.println("6. Regresar al menu principal");
            System.out.println("Seleccione una opcion: ");
            opcion = entrada.nextInt();
            
            switch (opcion){
            case 1: //Leer Categorias Existentes
                System.out.println("---------------CATEGORIAS EXISTENTES---------------");
                try {
                    FileReader categoriasFileReader = new FileReader(categorias);
                    BufferedReader categoriasbr = new BufferedReader(categoriasFileReader);
                    String linea = "";
                    while ((linea = categoriasbr.readLine())!= null){
                            System.out.println(linea);
                           } 
                    categoriasbr.close();       
                    } 
                catch (IOException ex){
                       //Logger.getLogger(ProyectSistemaGestionDeInventarios.class.getName()).log(Level.SEVERE, null, ex); 
                        System.out.println("Error: El archivo no se encuentra: " + ex.getMessage());
                    }
                break;  
  
            case 2: //Agregar Categoria
                System.out.println("---------------AGREGAR NUEVA CATEGORIA---------------");
                AgregarCategoria();
                break;
                
            case 3: //Modificacion de Categorias
                System.out.println("---------------MODIFICAR CATEGORIA---------------");
                ModificarCategorias();
                break;
                
            case 4: //Eliminar categoria existente
                System.out.println("---------------ELIMINAR CATEGORIA---------------");
                EliminarCategoria();
                break;
            
            case 5: //productos
                
                break; 
            
            case 6: //Eliminar categoria existente
                MenuPrincipal();
                break; 
                
            default: 
                System.out.println("Ingrese una opcion valida");
            }    
            
        } //Fin del metodo/subalgoritmo MenuGestionDeProductos
        
        
        
            //opcion 2 del menu gestion de productos
            public static void AgregarCategoria () {  
                Scanner entrada = new Scanner(System.in);
                String categorias = ".\\src\\proyectsistemagestiondeinventarios\\Categorias.txt";
                String nomCategoria = ""; int opcion;
                
                do{
                    try {
                        FileReader fr = new FileReader(categorias);
                        BufferedReader br = new BufferedReader(fr);
                        
                        String linea;
                        boolean categoriaExistente = false;
                        System.out.println("Ingrese un nombre para de la Nueva Categoria:");
                        nomCategoria = entrada.nextLine();  
                        nomCategoria = nomCategoria.toUpperCase();
                        
                        //validacion de que el  nombre de la categoria no este vacío y no exista otra categoria con el mismo nombre
                        while ((linea=br.readLine())!=null){
                                if (linea.equals(nomCategoria)){
                                categoriaExistente = true;
                                break;
                                }
                            }
                        br.close();
                        
                        if(nomCategoria.isEmpty()){
                            System.out.println("El nombre de la categoria no puede estar vacio");
                            }else if(categoriaExistente){
                            System.out.println("Ya existe una categoria con ese nombre.");
                            } else { 
                                FileWriter fw = new FileWriter(categorias, true);
                                BufferedWriter bw = new BufferedWriter (fw);
                                bw.write(nomCategoria);
                                bw.newLine();
                                bw.close();
                                System.out.println("Categoria creada exitosamente");
                                }
                    } catch (IOException ex){
                               System.out.println("Error al escribir en el archivo: " + ex.getMessage());  
                               } 
                    System.out.println("Desea agregar otra categoria?");
                    System.out.println("1. Si   2. No, regresar al menú de gestion de productos");
                    System.out.print("Selecciones una opcion: ");
                    opcion = entrada.nextInt();
                    entrada.nextLine(); //para limpiar el buffer
                    
                } while (opcion==1);
                
                
            }//Fin del metodo/subalgoritmo AgregarCategoria
            
            
            //opcion 3 del menu gestion de productos
            public static void ModificarCategorias (){
                Scanner scan = new Scanner(System.in);
                String categoriasRuta = ".\\src\\proyectsistemagestiondeinventarios\\Categorias.txt";
                int opcion;
                ArrayList<String> nomCategorias = new ArrayList<>(); //<> vacío para no sobrecargar
                
                do {
                    try {   
                        FileReader fr = new FileReader(categoriasRuta);
                        BufferedReader br = new BufferedReader(fr); 
                        String linea;
                        while ((linea = br.readLine()) != null) {
                                nomCategorias.add(linea);
                               }
                        br.close();
                        
                        System.out.println("Ingrese el nombre de la Categoria que desea modificar");
                        String nombreCategoria = scan.nextLine().toUpperCase();
                        
                        boolean categoriaEncontrada = false;
                        
                        //For para buscar la categoria a modificar
                        for (int i = 0; i < nomCategorias.size(); i++) {
                            if(nomCategorias.get(i).equals(nombreCategoria)){
                                categoriaEncontrada = true;
                                System.out.println("Categoría encontrada: " + nomCategorias.get(i));
                                System.out.println("Ingrese el nuevo nombre para la categoria:");
                                String nuevoNombre = scan.nextLine().toUpperCase(); // Leer el nuevo nombre
                                nomCategorias.set(i, nuevoNombre); // Modificar la categoría en la lista
                                break;
                               }   
                            }
                        
                        if (!categoriaEncontrada) {
                            System.out.println("Categoría no encontrada.");
                            return; // Si no se encuentra, terminar el método
                            }
                        
                        // Sobrescribir el archivo con las categorías modificadas
                        FileWriter fw = new FileWriter(categoriasRuta);
                        BufferedWriter bw = new BufferedWriter(fw);
                        for (String categoria : nomCategorias) {
                            bw.write(categoria);
                            bw.newLine(); // Escribir cada categoría en una nueva línea
                            }
                            bw.close(); // Cerrar el BufferedWriter

                        System.out.println("Categoria modificada exitosamente.");
                        } 
                        catch (IOException ex){
                                System.out.println("Error al modificar la categoria: " + ex.getMessage());
                        }
                        
                         // Preguntar si desea seguir modificando o salir al menú anterior
                        System.out.println("Desea seguir modificando categorias?");
                        System.out.println("1. Si");
                        System.out.println("2. No, regresar al menú anterior");
                        System.out.print("Opcion: ");
                        opcion = scan.nextInt();
                        scan.nextLine(); // Consumir la línea nueva
                        

                } while (opcion == 1); // Repite si elige la opción 1             
            }//Fin del metodo/subalgoritmo ModificarCategoria
     
            public static void EliminarCategoria(){
                Scanner scan = new Scanner(System.in);
                String categoriasRuta = ".\\src\\proyectsistemagestiondeinventarios\\Categorias.txt";
                int opcion;
                ArrayList<String> nomCategorias = new ArrayList<>(); //<> vacío para no sobrecargar 
            
                do {
                    try {
                        // Leer el archivo y cargar las categorías en la lista
                        FileReader fr = new FileReader(categoriasRuta);
                        BufferedReader br = new BufferedReader(fr);
                        String linea;
                        nomCategorias.clear(); // Limpiar la lista antes de cargar nuevas categorías
                        while ((linea = br.readLine()) != null) {
                                nomCategorias.add(linea); // Agregar cada categoría a la lista
                                }
                        br.close(); 

                        // Mostrar las categorías al usuario
                            System.out.println("Categorias actuales:");
                            for (String categoria : nomCategorias) {
                                System.out.println(categoria);
                                }

                        // Solicitar el nombre de la categoría que desea eliminar
                        System.out.println("Ingrese el nombre de la categoria que desea eliminar:");
                        String nombreCategoria = scan.nextLine().toUpperCase(); // Convertir a mayúsculas para uniformidad

                        boolean categoriaEncontrada = false;

                        // Buscar y eliminar la categoría
                        for (int i = 0; i < nomCategorias.size(); i++) {
                            if (nomCategorias.get(i).equals(nombreCategoria)) {
                                categoriaEncontrada = true;
                                nomCategorias.remove(i); // Eliminar la categoría de la lista
                                System.out.println("Categoria eliminada exitosamente: " + nombreCategoria);
                                break;
                                }
                            }

                        if (!categoriaEncontrada) {
                             System.out.println("Categoria no encontrada.");
                            }

                        // Sobrescribir el archivo con las categorías actualizadas
                        FileWriter fw = new FileWriter(categoriasRuta);
                        BufferedWriter bw = new BufferedWriter(fw);
                        for (String categoria : nomCategorias) {
                            bw.write(categoria);
                            bw.newLine(); // Escribir cada categoría en una nueva línea
                            }
                             bw.close(); // Cerrar el BufferedWriter

                    } catch (IOException ex) {
                            System.out.println("Error al eliminar la categoria: " + ex.getMessage());
                            }

                         // Preguntar si desea seguir eliminando o salir al menú anterior
                            System.out.println("Desea seguir eliminando categorias?");
                            System.out.println("1. Sí");
                            System.out.println("2. No, regresar al menu anterior");
                            System.out.print("Opcion: ");
                            opcion = scan.nextInt();
                            scan.nextLine(); 

                            } while (opcion == 1);
                            
            }//Fin del metodo EliminarCategoria()
            
            
            
//---------------------------------------------------------------------------------------------------------------------------------------------------------        
    
    public static void Productos() throws IOException{
        Scanner scan = new Scanner(System.in);
        String productosRuta = ".\\src\\proyectsistemagestiondeinventarios\\Productos.txt";
        String nomCategoria = ""; int opcion;
        
        try{
            FileReader fr = new FileReader(productosRuta);
            BufferedReader br = new BufferedReader(fr);
             
            String[][] datosProductos = new String[10][2]; // Supongamos que se tiene un máximo de 10 productos
            String linea;
            int contador = 0;

            // Leer datos del archivo
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split("\\|");
                if (campos.length >= 1) {
                    for (int i = 0; i < campos.length && i < 1; i++) {
                        datosProductos[contador][i] = campos[i];
                    }
                    contador++;
                } else {
                    System.out.println("Línea con datos incompletos: " + linea);
                }
            }

            System.out.print("Ingrese código a buscar: ");
            String codigo = scan.nextLine();
            int indiceAModificar = -1;

            // Buscar el estudiante por código
            for (int i = 0; i < contador; i++) {
                if (datosProductos[i][0] != null && datosProductos[i][0].equals(codigo)) {
                    System.out.println("Producto encontrado: " + datosProductos[i][1] + " " + datosProductos[i][2]);
                    indiceAModificar = i;
                    break; // Salir una vez que se encuentre el producto
                }
            }

            // Verificar si se encontró el índice
            if (indiceAModificar != -1) {
                System.out.print("Ingrese el nuevo nombre: ");
                String nuevoNombre = scan.nextLine();
                datosProductos[indiceAModificar][1] = nuevoNombre;
                
                System.out.println("Nombre modificado a: " + datosProductos[indiceAModificar][1] + " " + datosProductos[indiceAModificar][2]);
            } else {
                System.out.println("Código no encontrado.");
                return; // Salir si no se encuentra el estudiante
            }

            // Escribir de nuevo los datos en el archivo
            try {
                FileWriter fw = new FileWriter(productosRuta);
                BufferedWriter bw = new BufferedWriter(fw);
             
                for (int i = 0; i < contador; i++) {
                    if (datosProductos[i][0] != null) {
                        bw.write(String.join("|", datosProductos[i]) + "\n");
                    }
                }
                System.out.println("Datos guardados exitosamente.");
            } catch (FileNotFoundException ex) {
            System.out.println("El archivo no se encontró: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al leer o escribir en el archivo: " + ex.getMessage());
        }
        }catch (IOException ex){}
       
    }//Fin del metodo Productos()   

    
} //Fin de la clase Proyecto 
