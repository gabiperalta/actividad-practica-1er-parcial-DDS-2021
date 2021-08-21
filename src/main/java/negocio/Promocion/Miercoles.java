package negocio.Promocion;

import negocio.Cine.Entrada;
import negocio.Promocion.Promocion;

public class Miercoles extends Promocion {
    private static int porcentajedescuento = 25;
    @Override
    public void precioEntradas(Entrada entrada) {
        int precioEntrada = entrada.getPrecioGeneral();
        //25 % de descuento
        precioEntrada = precioEntrada -(precioEntrada * porcentajedescuento);
        //en caso de querer hacer un 2X1
        //precioEntrada = precioEntrada - (precioEntrada/2);
        entrada.setPrecioFinal(precioEntrada);
    }
}
