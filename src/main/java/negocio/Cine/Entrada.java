package negocio.Cine;

import negocio.Cliente.Cliente;
import negocio.Facturacion.Facturacion;
import negocio.Promocion.Promocion;

import java.time.DateTimeException;

public class Entrada {
    private Cliente cliente;
    private int numeroSala;
    private int precioGeneral;
    private Promocion promocion;
    private int precioFinal;
    private DateTimeException fechaLimite;
    private PeliculaOld peliculaOld;
    public Entrada(Cliente cliente, int numeroSala, int precioGeneral, Promocion promocion, PeliculaOld peliculaOld)
    {
        this.cliente = cliente;
        this.numeroSala = numeroSala;
        this.precioGeneral = precioGeneral;
        this.promocion = promocion;
       // this.fechaLimite = fechaLimite;
        this.peliculaOld = peliculaOld;
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
}
