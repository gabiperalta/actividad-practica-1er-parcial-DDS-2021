package negocio.Cine;

import java.time.DateTimeException;
import java.util.HashMap;

public class Funcion {
    private int numeroSala;
    private int asientosTotales;
    private int asientosLibres;
    private int ubicacionAsiento;
    private DateTimeException horarioInicio;
    private DateTimeException horarioFin;
    private Pelicula pelicula;
    private HashMap<Boolean,Entrada> Entradas;

    public Entrada reservarEntrada(Funcion funcion, String filaColumna) {
        //buscar entrada
        Entrada entrada = new Entrada();
        return entrada;
    }
}
