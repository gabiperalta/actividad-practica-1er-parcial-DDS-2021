package negocio.pelicula;

import java.util.List;

public class ListadoDePeliculas {
    //public List<DateAPI> dates;
    public DateAPI dates;
    public int page;
    public List<PeliculaAdapter> results;
    public int total_pages;
    public int total_results;

    public List<PeliculaAdapter> getResults() {
        return results;
    }
}
