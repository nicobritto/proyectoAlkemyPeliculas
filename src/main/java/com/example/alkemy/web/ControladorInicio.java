package com.example.alkemy.web;


import com.example.alkemy.domain.Pelicula;
import com.example.alkemy.servicio.PeliculaService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping("/")
    public String inicio(Model model) {
        var personas = peliculaService.listaPeliculas();
        log.info("ejecutando el controlador Spring MVC a consola");
        model.addAttribute("personas", personas);
        return "index";
    }

    @GetMapping("/agregar")//cuando precionamos agregar nos redirige ala paguina modificar
    public String agregar(Pelicula pelicula) {
        return "modificar";
    }

    @PostMapping("/guardar")//boton del formulario  guardar
    public String guardar(@Valid Pelicula pelicula,Errors errores) {
        if (errores.hasErrors()) {
            return "modificar";
        }
        //atraves de la persona servise guardamos los datos que nos manda la paguina
        peliculaService.guardar(pelicula);
        return "redirect:/";
    }

    @GetMapping("/editar/{idPelicula}")
    public String editar(Pelicula pelicula,Model model) {
        pelicula=peliculaService.encontrarPelicula(pelicula);
        model.addAttribute("pelicula",pelicula);
        return "modificar";
    }
    
    @GetMapping("/eliminar/{idPelicula}")
    public String eliminar(Pelicula pelicula,Model model) {
        peliculaService.eliminar(pelicula);
        return "redirect:/";
    }

}
