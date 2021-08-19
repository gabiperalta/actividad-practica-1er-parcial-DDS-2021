package negocio.pelicula;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface PeliculasServices {
    @GET("movie/now_playing")
    Call<ListadoDePeliculas> enCartelera(@Query("api_key") String apiKey, @Query("page") String pagina, @Query("region") String region);
    @GET("movie/upcoming")
    Call<ListadoDePeliculas> proximamente(@Query("api_key") String apiKey, @Query("page") String pagina, @Query("region") String region);
}
