package com.example.alkemy.servicio;

import com.example.alkemy.domain.Pelicula;
import java.util.List;

public interface PeliculaService {
    
    public List<Pelicula> listaPeliculas();
    
    public void guardar(Pelicula pelicula);
    
    public void eliminar(Pelicula pelicula);
    
    public Pelicula encontrarPelicula(Pelicula pelicula);
    
}
