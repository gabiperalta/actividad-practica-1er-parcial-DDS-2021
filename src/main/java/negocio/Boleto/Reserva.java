package negocio.Boleto;

import negocio.Cine.Funcion;
import negocio.Cliente.Cliente;
import negocio.Promocion.Promocion;

public class Reserva extends EstadoBoleto{
    private String codigoReserva;
    private Cliente cliente;
    private int numeroSala;
    private int precioGeneral;
    private int precioFinal;
    private Funcion funcion;
    private Promocion promocion;
    private String filaColumna;
    public void cancelarReserva(Cliente cliente)
    {
        this.funcion.disponibilidadBoleto(this.filaColumna,true);
    }
    public void  pagarReserva(Boleto boleto)
    {
        Boleto nuevaEntrada = new Boleto(this.cliente,this.funcion,this.filaColumna,this);
        cliente.removeReserva(boleto);
        cliente.addEntrada(nuevaEntrada);
    }
}
