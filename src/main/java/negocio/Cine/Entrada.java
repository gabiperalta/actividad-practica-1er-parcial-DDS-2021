package negocio.Cine;

import negocio.Cliente.Cliente;
import negocio.Facturacion.Facturacion;
import negocio.Promocion.Promocion;

import java.time.DateTimeException;

public class Entrada {
    private Cliente cliente;
    private int numeroSala;
    private double precio;
    private Promocion promocion;
    private DateTimeException fechaLimite;
    private Pelicula pelicula;

    public void generarFactura(Facturacion facturador){};
}
