/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carteleraantoniopinar;

import java.util.Comparator;

/**
 *
 * @author antonio
 */
public class CompararPelisPorGenero implements Comparator<PeliculaAntonio>{
    
    @Override
    public int compare(PeliculaAntonio p1, PeliculaAntonio p2){
        if(p1.getGenero().compareToIgnoreCase(p2.getGenero()) == 0){
            return p1.getDireccion().compareToIgnoreCase(p2.getDireccion());
        }else{
            return p1.getGenero().compareToIgnoreCase(p2.getGenero());
        }
    }
    
}
