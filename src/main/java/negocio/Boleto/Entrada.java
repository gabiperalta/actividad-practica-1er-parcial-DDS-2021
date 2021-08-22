package negocio.Boleto;

import negocio.Cine.Funcion;
import negocio.Cliente.Cliente;
import negocio.Facturacion.Facturacion;
import negocio.Promocion.Promocion;

public class Entrada extends Boleto {
    private Cliente cliente;
    private int numeroSala;
    private int precioGeneral;
    private int precioFinal;
    private Funcion funcion;
    private Promocion promocion;
    private String filaColumna;
    public Entrada(Cliente cliente,int numeroSala,int precioGeneral,Promocion promocion,Funcion funcion,String filaColumna)
    {
        this.cliente = cliente;
        this.numeroSala = numeroSala;
        this.precioGeneral = precioGeneral;
        this.promocion = promocion;
        this.funcion = funcion;
        this.filaColumna = filaColumna;
    }
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
    public void generarFactura(Facturacion facturador){};
}
