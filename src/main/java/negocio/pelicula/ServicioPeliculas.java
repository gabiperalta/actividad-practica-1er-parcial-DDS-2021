package negocio.pelicula;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ServicioPeliculas {
    private ServicioPeliculas instancia = null;
    private static final String urlAPI = "https://api.themoviedb.org/3/";
    private static final String api_key = "e13b1ea5ee4e10a0abe44e409721a9f6";
    private Retrofit retrofit;

    private ServicioPeliculas() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(urlAPI)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public ServicioPeliculas getInstancia() {
        if(instancia == null)
        {
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

    // retorna una lista de los hogares que se encuentran en la api segun la pagina indicada
    public List<Pelicula> listadoDeHogaresAdapter(int pagina) throws IOException {
        HogaresServices hogaresServices = this.retrofit.create(HogaresServices.class);
        Call<ListadoDeHogares> requestHogares = hogaresServices.hogares("Bearer " + token,String.valueOf(pagina));
        Response<ListadoDeHogares> responseHogares = requestHogares.execute();
        List<Hogar> listadoHogares = new ArrayList<>();
        if(responseHogares.body() != null)
            listadoHogares = responseHogares.body().getHogares().stream().map(HogarAdapter::getHogar).collect(Collectors.toList());
        return listadoHogares;
    }
    */
}
