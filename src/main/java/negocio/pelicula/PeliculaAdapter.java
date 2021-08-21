package negocio.pelicula;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PeliculaAdapter {
    private List<Integer> genre_ids;
    private int id;
    private String release_date;
    private String title;
    private List<String> actores;
    private List<String> generos;
    private Pelicula pelicula = null;

    public Pelicula getPelicula(){
        if(pelicula == null)
            pelicula = new Pelicula(title, generos, actores, this.getEstrenoAsLocalDate());
        return pelicula;
    }

    public int getId() {
        return id;
    }

    public List<Integer> getGenre_ids() {
        return genre_ids;
    }

    public void setActores(List<String> actores){
        this.actores = actores;
    }

    public void setGeneros(List<String> generos){
        this.generos = generos;
    }

    private LocalDate getEstrenoAsLocalDate(){
        return LocalDate.parse(this.release_date);
    }
}