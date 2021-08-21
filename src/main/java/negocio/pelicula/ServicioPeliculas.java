package negocio.pelicula;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.print.attribute.standard.JobSheets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ServicioPeliculas {
    private static ServicioPeliculas instancia = null;
    private static final String urlAPI = "https://api.themoviedb.org/3/";
    private static final String apiKey = "e13b1ea5ee4e10a0abe44e409721a9f6";
    private Retrofit retrofit;

    private ServicioPeliculas() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(urlAPI)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ServicioPeliculas getInstancia() {
        if(instancia == null) {
            instancia = new ServicioPeliculas();
        }
        return instancia;
    }

    /*
    public List<Pelicula> listadoDePeliculasEnCartelera(int pagina) throws IOException {
        HogaresServices hogaresServices = this.retrofit.create(HogaresServices.class);
        Call<ListadoDeHogares> requestHogares = hogaresServices.hogares("Bearer " + token,String.valueOf(pagina));
        Response<ListadoDeHogares> responseHogares = requestHogares.execute();
        return responseHogares.body();
    }
    */

    public ListadoDePeliculas getPeliculasEnCartelera(int pagina) throws IOException {
        PeliculasServices peliculasServices = this.retrofit.create(PeliculasServices.class);
        //Call<ListadoDeHogares> requestHogares = hogaresServices.hogares("Bearer " + token,String.valueOf(pagina));
        //Response<ListadoDeHogares> responseHogares = requestHogares.execute();
        //List<Hogar> listadoHogares = new ArrayList<>();
        //if(responseHogares.body() != null)
        //    listadoHogares = responseHogares.body().getHogares().stream().map(HogarAdapter::getHogar).collect(Collectors.toList());
        //return listadoHogares;
        Call<ListadoDePeliculas> requestPeliculas = peliculasServices.enCartelera(apiKey,String.valueOf(pagina),"AR");
        Response<ListadoDePeliculas> responsePeliculas = requestPeliculas.execute();
        return responsePeliculas.body();
    }

    public List<Pelicula> getPeliculasEnCartelera() throws IOException {
        List<Pelicula> peliculas = new ArrayList<>();

        PeliculasServices peliculasServices = this.retrofit.create(PeliculasServices.class);
        Call<ListadoDePeliculas> requestPeliculas = peliculasServices.enCartelera(apiKey,String.valueOf(1),"AR");
        Response<ListadoDePeliculas> responsePeliculas = requestPeliculas.execute();
        List<PeliculaAdapter> peliculasAdapter = new ArrayList<>();
        if(responsePeliculas.body() != null)
            peliculasAdapter = responsePeliculas.body().getResults();

        // Obtener lista de actores
        peliculasAdapter.forEach(peliculaAdapter -> peliculaAdapter.setActores(this.getActoresPorPelicula(peliculaAdapter.getId())));

        // Obtener generos
        List<String> generos = new ArrayList<>();
        peliculasAdapter.forEach(peliculaAdapter -> {
            peliculaAdapter.getGenre_ids().forEach(genre_id -> generos.add(this.getGeneroDePelicula(genre_id)));
            peliculaAdapter.setGeneros(generos);
        });

        peliculas = responsePeliculas.body().getResults().stream().map(PeliculaAdapter::getPelicula).collect(Collectors.toList());
        return peliculas;
    }

    private List<String> getActoresPorPelicula(int idPelicula){
        PeliculasServices peliculasServices = this.retrofit.create(PeliculasServices.class);
        Call<JsonObject> requestActores = peliculasServices.actoresPorPelicula(String.valueOf(idPelicula),apiKey);
        Response<JsonObject> responseActores = null;
        try {
            responseActores = requestActores.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> actores = new ArrayList<>();

        try{
            JsonArray jsonArrayActores = responseActores.body().getAsJsonArray("cast");
            jsonArrayActores.forEach(jsonElement -> actores.add(jsonElement.getAsJsonObject().get("name").getAsString()));
        } catch (NullPointerException e){
            return actores;
        }
        return actores;
    }

    public String getGeneroDePelicula(int idGenero){
        PeliculasServices peliculasServices = this.retrofit.create(PeliculasServices.class);
        Call<JsonObject> requestGeneros = peliculasServices.generosDePelicula(apiKey);
        Response<JsonObject> responseGeneros = null;
        ArrayList<JsonObject> generos = new ArrayList<>();
        try {
            responseGeneros = requestGeneros.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonArray jsonArrayGeneros;
        try{
            jsonArrayGeneros = responseGeneros.body().getAsJsonArray("genres");
        } catch (NullPointerException e){
            jsonArrayGeneros = new JsonArray();
        }
        jsonArrayGeneros.forEach(jsonElement -> generos.add(jsonElement.getAsJsonObject()));

        return generos.stream().filter(jsonObjectGenero -> jsonObjectGenero.get("id").getAsInt() == idGenero).collect(Collectors.toList()).get(0).get("name").getAsString();
    }
}
