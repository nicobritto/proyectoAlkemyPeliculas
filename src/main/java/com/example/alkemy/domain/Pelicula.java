package com.example.alkemy.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "pelicula")
public class Pelicula implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPelicula;

    @NotEmpty
    private String imagen;
    @NotEmpty
    private String titulo;
    @NotEmpty
    private String fecha_de_creacion;
    @NotEmpty
    private String calificacion;
    private String personajes_asociados;
}
