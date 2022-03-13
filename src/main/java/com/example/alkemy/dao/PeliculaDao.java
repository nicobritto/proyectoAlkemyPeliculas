package com.example.alkemy.dao;

import com.example.alkemy.domain.Pelicula;
import org.springframework.data.repository.CrudRepository;

public interface PeliculaDao extends CrudRepository<Pelicula, Long> {
    
}
