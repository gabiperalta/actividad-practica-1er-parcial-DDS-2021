package negocio.Promocion;

import negocio.Cine.Entrada;

public class SinPromocion extends Promocion {
    private static int porcentajedescuento = 0;
    @Override
    public void precioEntradas(Entrada entrada) {
        int precioEntrada = entrada.getPrecioGeneral();
        //0 % de descuento
        precioEntrada = precioEntrada -(precioEntrada * porcentajedescuento);
        entrada.setPrecioFinal(precioEntrada);
    }
}
