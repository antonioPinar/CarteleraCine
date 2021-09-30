/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carteleraantoniopinar;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author antonio
 */
public class CarteleraAntonioPinar {

    public static void anadirPelicula(ArrayList<PeliculaAntonio> listaPeliculas){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduce titulo: ");
        String titulo = sc.nextLine();
        System.out.println("Introduce año de produccion: ");
        int anioProduccion = Integer.parseInt(sc.nextLine());
        System.out.println("Introduce duracion en minutos: ");
        int duracionMin = Integer.parseInt(sc.nextLine());
        System.out.println("Introduce genero: ");
        String genero = sc.nextLine();
        System.out.println("Introduce direccion de pelicula: ");
        String direccion = sc.nextLine();
        System.out.println("Introduce protagonistas: ");
            ArrayList<String> protagonistas = new ArrayList<String>();
            String prota = sc.nextLine();
            String decision;
            protagonistas.add(prota);
            do{
                System.out.println("¿Quieres seguir introduciendo actores? ");
                decision = sc.nextLine();
                if(decision.equals("si")){
                    System.out.println("Introduce protagonistas: ");
                    prota = sc.nextLine();
                    protagonistas.add(prota);
                }
            }while(decision.equals("si"));
        PeliculaAntonio peli = new PeliculaAntonio(titulo, anioProduccion, duracionMin, genero, direccion, protagonistas);
        listaPeliculas.add(peli);
    }
    
    public static void borrarPelicula(ArrayList<PeliculaAntonio> listaPeliculas){
        Scanner sc = new Scanner(System.in);
        
        boolean encontrado = false;
        System.out.println("Introduce pelicula que deseas borrar: ");
        String titulob = sc.nextLine();
        for(int i = 0; i < listaPeliculas.size(); i++){
            if(listaPeliculas.get(i).getTitulo().equalsIgnoreCase(titulob)){
                listaPeliculas.remove(i);
                encontrado = true;
                System.out.println("Pelicula borrada. ");
            } 
        }
        if(encontrado == false){
            System.out.println("Pelicula no encontrada. ");
        }
    }
    
    public static void volcadoAFichero(File fichero, ArrayList<PeliculaAntonio> lista){
        try{
            ObjectOutputStream flujo_salida = new ObjectOutputStream(new FileOutputStream(fichero));
            PeliculaAntonio peli;
            for(int i = 0; i < lista.size(); i++){
                peli = lista.get(i);
                flujo_salida.writeObject(peli);
            }
            flujo_salida.close();
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error, fichero no encontrado "+ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error de datos "+ex.getMessage());
        }
    }
    
    public static void volcadoALista(File fichero, ArrayList<PeliculaAntonio> lista){
        ObjectInputStream flujo_entrada = null;
        try{
            flujo_entrada = new ObjectInputStream(new FileInputStream(fichero));
            PeliculaAntonio peli;
            while(true){
                peli = (PeliculaAntonio)flujo_entrada.readObject();
                lista.add(peli);
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error, fichero no encontrado "+ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Fin de datos en lista "+ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Error, clase no encontrada "+ex.getMessage());
        }finally{
            try{
                if(flujo_entrada != null){
                    flujo_entrada.close();
                }
            } catch (IOException ex) {
                System.out.println("Error de datos 2 "+ ex.getMessage());
            }
        }
    }
    
    public static void mostrarFichero(File fichero){
        ObjectInputStream ois = null; // Flujo de datos desde el fichero (Lectura)
        try {
            // abrir un flujo de entrada de datos (lectura) desde el fichero
            ois = new ObjectInputStream(new FileInputStream(fichero));

            // Declarar un objeto Persona paraguardar el objeto leído.
            PeliculaAntonio peli;

            while (true) {
                peli = (PeliculaAntonio) ois.readObject();
                System.out.println(peli.toString());
                
            }

        } catch (EOFException eofe) {
            System.out.println("Fin del listado");
        } catch (FileNotFoundException fnfe) {
            System.out.println("No existe el fichero ");
        } catch (ClassNotFoundException e) {
            System.out.println("Error1: " + e.getMessage());
        } catch (IOException ioe) {
            System.out.println("Error2: " + ioe.getMessage());
        } finally {
            try {
                // Cerrar el flujo
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ioe) {
                System.out.println("Error3: " + ioe.getMessage());
            }
        }
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ArrayList<PeliculaAntonio> listaPeliculas = new ArrayList<PeliculaAntonio>();
        int resp;
        
        String nombreFichero = null; // nombre del fichero
        File fichero = null; // objeto que identifica el fichero
        // Crea un objeto File que identifique al fichero
        System.out.print("Introduce nombre del fichero: ");
        nombreFichero = sc.nextLine();
        fichero = new File(nombreFichero);

        // Verifica si el fichero existe
        if (fichero.exists()) {
            System.out.print("Fichero existente, volcamos contenido del fichero a nuestra lista \n");
            volcadoALista(fichero, listaPeliculas);
        }
        
        do{
            System.out.println("            Menu");
            System.out.println("1. Añadir pelicula \n"
                            + "2. Borrar pelicula \n"
                            + "3. Consultar pelicula \n"
                            + "4. Ordenar lista de peliculas por año de produccion \n"
                            + "5. Ordenar lista de peliculas por duracion \n"
                            + "6. Ordenar lista de peliculas por genero \n"
                            + "7. salir");
            resp = Integer.parseInt(sc.nextLine());
            
            switch(resp){
                case 1:
                    anadirPelicula(listaPeliculas);
                    break;
                case 2:
                    borrarPelicula(listaPeliculas);
                    break;
                case 3:
                    for(PeliculaAntonio aux: listaPeliculas){
                        System.out.println(aux);
                    }
                    break;
                case 4:
                    Collections.sort(listaPeliculas);
                    for(PeliculaAntonio aux : listaPeliculas){
                        System.out.println(aux);
                    }
                    break;
                case 5:
                    Collections.sort(listaPeliculas, new CompararPelisPorDuracion());
                    for(PeliculaAntonio aux : listaPeliculas){
                        System.out.println(aux);
                    }
                    break;
                case 6:
                    Collections.sort(listaPeliculas, new CompararPelisPorGenero());
                    for(PeliculaAntonio aux : listaPeliculas){
                        System.out.println(aux);
                    }
                    break;
            }
        }while(resp != 7);
        
        System.out.println("Introducimos el listado de nuestra cartelera a la lista.");
        volcadoAFichero(fichero, listaPeliculas);
        
        System.out.println("¿Deseas visualizar el contenido del fichero? [si/no]");
        String resp2 = sc.nextLine();
        if(resp2.equalsIgnoreCase("si")){
            mostrarFichero(fichero);
        }else{
            System.out.println("Cartelera cerrada.");
        }
    }
    
}
