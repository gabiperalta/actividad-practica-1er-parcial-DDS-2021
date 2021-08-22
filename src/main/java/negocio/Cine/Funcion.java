package negocio.Cine;

import negocio.Cineasta.Cliente;
import negocio.Promocion.FinDeSemana;
import negocio.Promocion.Miercoles;
import negocio.Promocion.Promocion;
import negocio.Promocion.SinPromocion;
import sun.util.calendar.LocalGregorianCalendar;

import java.sql.Time;
import java.time.DateTimeException;
import java.util.Date;
import java.util.HashMap;

public class Funcion {
    private int numeroSala;
    private int asientosTotales;
    private int asientosLibres;
    private int precioGeneral;
    private Dia dia;
    private Date fechaFuncion;
    private Pelicula pelicula;
    private HashMap<String,Boolean> ubicaciones;

    public Funcion(int numeroSala,int asientosTotales,int asientosLibres,int precioGeneral,Dia dia,Date fechaFuncion, Pelicula pelicula)
    {
        this.numeroSala = numeroSala;
        this.asientosTotales = asientosTotales;
        this.asientosLibres = asientosLibres;
        this.precioGeneral = precioGeneral;
        this.dia = dia;
        this.fechaFuncion = fechaFuncion;
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

    public Date getfechaFuncion() {
        return fechaFuncion;
    }

    public Boolean validarUbicacion(String ubicacionEsperada)
    {
        for (String key : ubicaciones.keySet())
        {
            if(key.equals(ubicacionEsperada))
            {
                Boolean ocupacion = ubicaciones.get(key);
                if(ocupacion)
                {
                    return  false;
                }
                else
                {
                    return true;
                }
            }
        }
        return false;
    }
    public Promocion obtenerPromocion()
    {
        Dia diaFuncion = this.dia;
        Promocion nuevapromo;
        if(diaFuncion == Dia.Miercoles)
        {
            nuevapromo = new Miercoles();
        }
        if(diaFuncion == Dia.Sabado || diaFuncion == Dia.Domingo)
        {
            nuevapromo = new FinDeSemana();
        }
        else
        {
            nuevapromo = new SinPromocion();
        }
        return nuevapromo;

    }
    public void disponibilidadBoleto(String filaColumna,Boolean disponibilidad)
    {
        for (String key : ubicaciones.keySet())
        {
            if(key.equals(filaColumna))
            {
                ubicaciones.replace(filaColumna,disponibilidad);
            }
        }
    }
   public Entrada solicitarEntrada(String filaColumna, Cliente cliente) {
           Promocion promo = this.obtenerPromocion();
           Entrada entradaNueva = new Entrada(cliente,this.numeroSala,this.precioGeneral,promo,this);
           this.disponibilidadBoleto(filaColumna,false);
           return entradaNueva;
    }
   /* public Entrada entradaAleatoria(Cliente cliente)
    {
        for (Boolean value : ubicaciones.values())
        {
            if(key.equals(ubicacionEsperada))
            {
                return false;
            }
        }
        return true;
    }*/
}
