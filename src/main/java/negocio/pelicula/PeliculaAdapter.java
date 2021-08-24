package negocio.pelicula;

import javax.swing.text.DateFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

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
            pelicula = new Pelicula(title, "Comedia", "juan perez", this.getEstrenoAsDate());
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

    private Date getEstrenoAsDate() {
        Date estreno;
        try{
            estreno = new SimpleDateFormat("yyyy-MM-dd").parse(release_date);
        }catch (ParseException e){
            estreno = new Date();
        }
        return estreno;
    }
}