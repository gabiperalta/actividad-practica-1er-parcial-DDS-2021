package negocio.Cine;

import negocio.Boleto.Boleto;
import negocio.Boleto.Entrada;
import negocio.Boleto.Reserva;
import negocio.Cliente.Cliente;
import negocio.Promocion.FinDeSemana;
import negocio.Promocion.Miercoles;
import negocio.Promocion.Promocion;
import negocio.Promocion.SinPromocion;
import negocio.pelicula.Pelicula;
import persistencia.Conexion;
import persistencia.funcion.FuncionDAO;

import java.util.Date;
import java.util.HashMap;

public class Funcion {
    private int id;
    private int numeroSala;
    private int asientosTotales;
    private int asientosLibres;
    private int precioGeneral;
    private int precioFinal;
    private Dia dia;
    private Date fechaFuncion;
    private Pelicula pelicula;
    private Promocion promocion;
    private HashMap<String,Boolean> ubicaciones;

    public Funcion(){

    }

    public Funcion(int numeroSala,int asientosTotales,int asientosLibres,int precioGeneral,Dia dia,Date fechaFuncion, Pelicula pelicula)
    {
        this.numeroSala = numeroSala;
        this.asientosTotales = asientosTotales;
        this.asientosLibres = asientosLibres;
        this.precioGeneral = precioGeneral;
        this.dia = dia;
        this.fechaFuncion = fechaFuncion;
        this.pelicula= pelicula;

        FuncionDAO funcionDAO = new FuncionDAO(Conexion.getInstance().getConnection());
        this.id = funcionDAO.insert(numeroSala,asientosLibres,asientosTotales,precioGeneral,dia,fechaFuncion,pelicula);
    }

    public void setPromocion(){
        Promocion promo  = this.obtenerPromocion();
        this.promocion = promo;
        this.precioFinal = promo.precioEntradas(this);
    }

    public Promocion getPromocion(){
        return this.promocion;
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

    public int getPrecioFinal() {
        return precioFinal;
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
        if(diaFuncion == Dia.Miercoles)
        {
            return new Miercoles();
        }
        if(diaFuncion == Dia.Sabado || diaFuncion == Dia.Domingo)
        {
            return  new FinDeSemana();
        }
        else
        {
            return new SinPromocion();
        }

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
    public Boleto solicitarEntrada(String filaColumna, Cliente cliente) {
        Boleto entradaNueva = new Boleto(cliente,this,filaColumna,new Entrada());
        this.disponibilidadBoleto(filaColumna,false);
        return entradaNueva;
    }

    public Boleto solicitarReserva(String filaColumna, Cliente cliente) {
        Boleto reservaNueva = new Boleto(cliente,this,filaColumna,new Reserva());
        this.disponibilidadBoleto(filaColumna,false);
        return reservaNueva;
    }

    public Boleto entradaAleatoria(Cliente cliente) {
        Boleto entrada = new Boleto(cliente,this,"vacio",new Entrada());

        for (String key : ubicaciones.keySet()) {
            if(ubicaciones.get(key)) {
                entrada.setFilaColumna(key);
                this.disponibilidadBoleto(key,false);
            }
        }
        return entrada;
    }

    public void setAsientosLibres(int asientosLibres) {
        this.asientosLibres = asientosLibres;
    }

    public void setAsientosTotales(int asientosTotales) {
        this.asientosTotales = asientosTotales;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public void setFechaFuncion(Date fechaFuncion) {
        this.fechaFuncion = fechaFuncion;
    }
}
