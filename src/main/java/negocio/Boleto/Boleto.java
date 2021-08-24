package negocio.Boleto;

import negocio.Cine.Funcion;
import negocio.Cliente.Cliente;
import negocio.Facturacion.Facturacion;

public class Boleto {
    private String codigo;
    private Cliente cliente;
    private int precioGeneral;
    private int precioFinal;
    private Funcion funcion;
    private String filaColumna;
    private EstadoBoleto estadoBoleto;
    public Boleto(Cliente cliente,Funcion funcion,String filaColumna,EstadoBoleto estadoBoleto)
    {
        this.cliente = cliente;
        this.precioGeneral = funcion.getPrecioGeneral();
        this.funcion = funcion;
        this.filaColumna = filaColumna;
        this.estadoBoleto = estadoBoleto;
        this.precioFinal = funcion.getPrecioFinal();
    }
    public void setEstadoBoleto(EstadoBoleto estado){this.estadoBoleto = estado;}
    public Cliente getCliente(){return this.cliente;};
    public int getNumeroSala(){return funcion.getNumeroSala();};
    public void setFilaColumna(String filaColumna){this.filaColumna = filaColumna;}
    public void setPrecioFinal(int precio)
    {
        this.precioFinal = precio;
    }
    public int getPrecioGeneral()
    {
        return this.precioGeneral;
    }
    public int getPrecioFinal() {
        return precioFinal;
    }
    public void generarFactura(Facturacion faturador)
    {
        faturador.generarFacturaBoleto(this);
    }

}
