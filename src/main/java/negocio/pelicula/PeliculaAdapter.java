package negocio.pelicula;

import java.util.ArrayList;
import java.util.List;

public class PeliculaAdapter {
    public boolean adult;
    public String backdrop_path;
    public List<Integer> genre_ids;
    public int id;
    public String original_language;
    public String original_title;
    public String overview;
    public Double popularity;
    public String poster_path;
    public String release_date;
    public String title;
    public boolean video;
    public float vote_average;
    public int vote_count;
    private Pelicula pelicula = null;

    public Pelicula getPelicula(){
        if(pelicula == null) {
            List<String> actores = new ArrayList<>();

            pelicula = new Pelicula(title, "", actores, null);
        }
        return pelicula;
    }
}