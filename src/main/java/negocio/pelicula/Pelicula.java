package negocio.pelicula;

import java.time.LocalDateTime;
import java.util.List;

public class Pelicula {
    private final String nombre;
    private final String genero;
    private final List<String> actores;
    private final LocalDateTime estreno;

    public Pelicula(String nombre, String genero, List<String> actores, LocalDateTime estreno){
        this.nombre = nombre;
        this.genero = genero;
        this.actores = actores;
        this.estreno = estreno;
    }
}
