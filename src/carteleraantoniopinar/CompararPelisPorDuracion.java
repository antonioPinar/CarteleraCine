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
public class CompararPelisPorDuracion implements Comparator<PeliculaAntonio>{
    
    @Override
    public int compare(PeliculaAntonio p1, PeliculaAntonio p2){
        if(p1.getDuracionEnMin() == p2.getDuracionEnMin()){
            return p1.getTitulo().compareToIgnoreCase(p2.getTitulo());
        }else{
            return p1.getDuracionEnMin() - p2.getDuracionEnMin();
        }
    }
}
