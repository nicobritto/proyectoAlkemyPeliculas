package com.example.alkemy.servicio;

import com.example.alkemy.dao.PeliculaDao;
import com.example.alkemy.domain.Pelicula;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PeliculaServiceImp implements PeliculaService {
    
    @Autowired
    private PeliculaDao peliculaDao;

    @Override
    @Transactional(readOnly=true)//Transactional si hay un error no se ejecuta la accion
    public List<Pelicula> listaPeliculas() {
     return   (List<Pelicula>) peliculaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Pelicula pelicula) {
         peliculaDao.save(pelicula);
    }

    @Override
    @Transactional
    public void eliminar(Pelicula pelicula) {
        peliculaDao.delete(pelicula);
    }

    @Override
    @Transactional(readOnly=true)
    public Pelicula encontrarPelicula(Pelicula pelicula) {
        return peliculaDao.findById(pelicula.getIdPelicula()).orElse(pelicula);
    }
    
    
}
