package negocio.Cine;

import negocio.Cineasta.Cliente;
import negocio.Promocion.FinDeSemana;
import negocio.Promocion.Miercoles;
import negocio.Promocion.Promocion;
import negocio.Promocion.SinPromocion;

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

    public int getAsientosLibres(){return this.asientosLibres;}
    public int getNumeroSala() {
        return numeroSala;
    }

    public void setUbicaciones(HashMap<String,Boolean> ubicaciones){this.ubicaciones = ubicaciones;}

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
                return  ubicaciones.get(key);
            }
        }
        return false;
    }
    public HashMap<String,Boolean> test(String ubicacionEsperada)
    {
        for (String key : ubicaciones.keySet())
        {
            if(key.equals(ubicacionEsperada))
            {
                Boolean ocupacion = ubicaciones.get(key);
                if(ocupacion)
                {

                }
            }
        }
        return ubicaciones;
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
            if(disponibilidad)
            {
                this.asientosLibres += 1;
            }
            if(!disponibilidad)
            {
                this.asientosLibres -= 1;
            }
        }
    }
   public Entrada solicitarEntrada(String filaColumna, Cliente cliente) {
           Promocion promo = this.obtenerPromocion();
           Entrada entradaNueva = new Entrada(cliente,this.numeroSala,this.precioGeneral,promo,this,filaColumna);
           this.disponibilidadBoleto(filaColumna,false);
           return entradaNueva;
    }
    public Reserva solicitarReserva(String filaColumna, Cliente cliente) {
        Promocion promo = this.obtenerPromocion();
        Reserva reservaNueva = new Reserva(cliente,this.numeroSala,this.precioGeneral,promo,this,filaColumna);
        this.disponibilidadBoleto(filaColumna,false);
        return reservaNueva;
    }
    public Entrada entradaAleatoria(Cliente cliente)
    {
        Promocion promo = this.obtenerPromocion();
        Entrada entrada = new Entrada(cliente,this.numeroSala,this.precioGeneral,promo,this,"vacio");

        for (String key : ubicaciones.keySet())
        {
            if(ubicaciones.get(key))
            {
                entrada.setFilaColumna(key);
                this.disponibilidadBoleto(key,false);
            }
        }

        return entrada;
    }
}
