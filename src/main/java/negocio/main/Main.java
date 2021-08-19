package negocio.main;

import negocio.pelicula.ListadoDePeliculas;
import negocio.pelicula.ServicioPeliculas;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("esto es una prueba");

        ListadoDePeliculas listadoDePeliculas = ServicioPeliculas.getInstancia().getPeliculasEnCartelera(1);


        System.out.println("esto es una prueba");
    }
}
