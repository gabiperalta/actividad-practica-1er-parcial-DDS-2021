package negocio.Boleto;

import negocio.Cine.Funcion;
import negocio.Cineasta.Cliente;
import negocio.Promocion.Promocion;

public abstract class Boleto {
    private Cliente cliente;
    private int numeroSala;
    private int precioGeneral;
    private int precioFinal;
    private Funcion funcion;
    private Promocion promocion;

}
