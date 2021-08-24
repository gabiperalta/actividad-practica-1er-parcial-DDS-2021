package negocio.Promocion;

import negocio.Boleto.Boleto;
import negocio.Boleto.Entrada;
import negocio.Cine.Funcion;

public class FinDeSemana extends Promocion {
    private static int porcentajedescuento = 10;
    public int setPorcentajedescuento()
    {
        return this.porcentajedescuento;
    }
    @Override
    public int precioEntradas(Funcion funcion) {
        int precioEntrada = funcion.getPrecioGeneral();
        //10 % de descuento
        int precio = precioEntrada - ((precioEntrada * porcentajedescuento)/100);
        return precio;
    }

}