package negocio.pelicula;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Pelicula {
    private String nombre;
    private String generos;
    private String actores;
    private LocalDate estreno;

    public Pelicula(){}

    public Pelicula(String nombre, String generos, String actores, LocalDate estreno){
        this.nombre = nombre;
        this.generos = generos;
        this.actores = actores;
        this.estreno = estreno;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setGeneros(String generos) {
        this.generos = generos;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public void setEstreno(LocalDate estreno) {
        this.estreno = estreno;
    }
}
