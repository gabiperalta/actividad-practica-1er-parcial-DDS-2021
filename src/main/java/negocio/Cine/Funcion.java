package negocio.Cine;

import negocio.Cliente.Cliente;

import java.time.DateTimeException;
import java.util.HashMap;

public class Funcion {
    private int numeroSala;
    private int asientosTotales;
    private int asientosLibres;
    private String ubicacionAsiento;
    private int precioGeneral;
    private String dia;
    private DateTimeException horarioInicio;
    private DateTimeException horarioFin;
    private Pelicula pelicula;
    private HashMap<Boolean,Entrada> Entradas;

    public Funcion(){

    }

    public Funcion(int numeroSala,int asientosTotales,int asientosLibres,String ubicacionAsiento,int precioGeneral,String dia,DateTimeException horarioInicio,DateTimeException horarioFin, Pelicula pelicula)
    {
        this.numeroSala = numeroSala;
        this.asientosTotales = asientosTotales;
        this.asientosLibres = asientosLibres;
        this.ubicacionAsiento = ubicacionAsiento;
        this.precioGeneral = precioGeneral;
        this.dia = dia;
        this.horarioInicio = horarioInicio;
        this.horarioFin = horarioFin;
        this.pelicula= pelicula;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public int getPrecioGeneral() {
        return precioGeneral;
    }

    public void setPrecioGeneral(int precioGeneral) {
        this.precioGeneral = precioGeneral;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public DateTimeException getHorarioFin() {
        return horarioFin;
    }

    public void setHorarioFin(DateTimeException horarioFin) {
        this.horarioFin = horarioFin;
    }

    public void setAsientosLibres(int asientosLibres) {
        this.asientosLibres = asientosLibres;
    }

    public void setAsientosTotales(int asientosTotales) {
        this.asientosTotales = asientosTotales;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public void setHorarioInicio(DateTimeException horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    /* public Entrada reservarEntrada(Funcion funcion, String filaColumna, Cliente cliente) {
        //buscar entrada
        //(Cliente cliente,int numeroSala,int precioGeneral,Promocion promocion,DateTimeException fechaLimite,Pelicula pelicula)
        //calcular Promocion en base al dia d ela funcion
        Entrada entrada = new Entrada();
        return entrada;
    }*/
}
