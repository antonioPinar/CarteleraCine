/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carteleraantoniopinar;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author antonio
 */
public class PeliculaAntonio implements Comparable<PeliculaAntonio>, Serializable{
    
    private String titulo;
    private int anioProduccion;
    private int duracionEnMin;
    private String genero;
    private String direccion;
    private ArrayList<String> protagonistas;

    public PeliculaAntonio(String titulo, int anioProduccion, int duracionEnMin, String genero, String direccion, ArrayList<String> protagonistas) {
        this.titulo = titulo;
        this.anioProduccion = anioProduccion;
        this.duracionEnMin = duracionEnMin;
        this.genero = genero;
        this.direccion = direccion;
        this.protagonistas = protagonistas;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnioProduccion() {
        return anioProduccion;
    }

    public int getDuracionEnMin() {
        return duracionEnMin;
    }

    public String getGenero() {
        return genero;
    }

    public String getDireccion() {
        return direccion;
    }

    public ArrayList<String> getProtagonistas() {
        return protagonistas;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAnioProduccion(int anioProduccion) {
        this.anioProduccion = anioProduccion;
    }

    public void setDuracionEnMin(int duracionEnMin) {
        this.duracionEnMin = duracionEnMin;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setProtagonistas(ArrayList<String> protagonistas) {
        this.protagonistas = protagonistas;
    }

    @Override
    public String toString() {
        return "PeliculaAntonio: \n"
                + "titulo = " + titulo + "\n"
                + " anioProduccion = " + anioProduccion + "\n"
                + " duracionEnMin = " + duracionEnMin + "\n"
                + " genero = " + genero + "\n"
                + " direccion = " + direccion + "\n"
                + " protagonistas = " + protagonistas +"\n";
    }
            
    @Override
    public int compareTo(PeliculaAntonio p){
        if(this.anioProduccion == p.anioProduccion){
            return this.titulo.compareToIgnoreCase(p.titulo);
        }else{
            return this.anioProduccion - p.anioProduccion;
        }
    }
    
    
}
