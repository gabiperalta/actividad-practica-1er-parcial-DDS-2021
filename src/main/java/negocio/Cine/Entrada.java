package negocio.Cine;

import negocio.Cliente.Cliente;
import negocio.Facturacion.Facturacion;
import negocio.Promocion.Promocion;
import negocio.pelicula.Pelicula;

import java.time.DateTimeException;

public class Entrada {
    private Cliente cliente;
    private int numeroSala;
    private int precioGeneral;
    private Promocion promocion;
    private int precioFinal;
    private DateTimeException fechaLimite;
    private Pelicula pelicula;

    public Entrada(){}

    public Entrada(Cliente cliente, int numeroSala, int precioGeneral, Promocion promocion, Pelicula pelicula) {
        this.cliente = cliente;
        this.numeroSala = numeroSala;
        this.precioGeneral = precioGeneral;
        this.promocion = promocion;
       // this.fechaLimite = fechaLimite;
        this.pelicula = pelicula;
    }
    public void setPrecioFinal(int precio)
    {
        this.precioFinal = precio;
    }
    public int getPrecioGeneral()
    {
        return this.precioGeneral;
    }
    public void generarFactura(Facturacion facturador){};

    public int getPrecioFinal() {
        return precioFinal;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public void setPrecioGeneral(int precioGeneral) {
        this.precioGeneral = precioGeneral;
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
}
