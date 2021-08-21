package negocio.pelicula;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Pelicula {
    private final String nombre;
    private final List<String> generos;
    private final List<String> actores;
    private final LocalDate estreno;

    public Pelicula(String nombre, List<String> generos, List<String> actores, LocalDate estreno){
        this.nombre = nombre;
        this.generos = generos;
        this.actores = actores;
        this.estreno = estreno;
    }
}
