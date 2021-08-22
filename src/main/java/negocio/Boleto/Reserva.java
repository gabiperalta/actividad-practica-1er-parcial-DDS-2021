package negocio.Boleto;

import negocio.Cine.Funcion;
import negocio.Cliente.Cliente;
import negocio.Promocion.Promocion;

public class Reserva {
    private String codigoReserva;
    private Estado estado;
    private Cliente cliente;
    private int numeroSala;
    private int precioGeneral;
    private int precioFinal;
    private Funcion funcion;
    private Promocion promocion;
    private String filaColumna;
    public Reserva(Cliente cliente,int numeroSala,int precioGeneral,Promocion promocion,Funcion funcion,String filaColumna)
    {
        this.cliente = cliente;
        this.numeroSala = numeroSala;
        this.precioGeneral = precioGeneral;
        this.promocion = promocion;
        this.funcion = funcion;
        this.filaColumna = filaColumna;
    }
    public void cancelarReserva()
    {
        this.estado = Estado.Cancelado;
        this.funcion.disponibilidadBoleto(this.filaColumna,true);
    }
    public void  pagarReserva()
    {
        this.estado = Estado.Pago;
        Entrada nuevaEntrada = new Entrada(this.cliente,this.numeroSala,this.precioGeneral,this.promocion,this.funcion,this.filaColumna);
        cliente.removeReserva(this);
        cliente.addEntrada(nuevaEntrada);
    }
}
