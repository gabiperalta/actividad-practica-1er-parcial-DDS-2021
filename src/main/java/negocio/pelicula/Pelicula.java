package negocio.pelicula;

import persistencia.Conexion;
import persistencia.pelicula.PeliculaDAO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Pelicula {
    private int id;
    private String nombre;
    private String generos;
    private String actores;
    private Date estreno;

    public Pelicula(){}

    public Pelicula(String nombre, String generos, String actores, Date estreno){
        this.nombre = nombre;
        this.generos = generos;
        this.actores = actores;
        this.estreno = estreno;

        PeliculaDAO peliculaDAO = new PeliculaDAO(Conexion.getInstance().getConnection());
        this.id = peliculaDAO.insert(nombre,generos,actores,estreno);
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

    public void setEstreno(Date estreno) {
        this.estreno = estreno;
    }

    public int getId() {
        return id;
    }
}
