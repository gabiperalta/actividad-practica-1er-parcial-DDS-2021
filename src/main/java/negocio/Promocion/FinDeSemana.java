package negocio.Promocion;

import negocio.Cine.Entrada;

public class FinDeSemana extends Promocion {
    private static int porcentajedescuento = 10;
    @Override
    public void precioEntradas(Entrada entrada) {
        int precioEntrada = entrada.getPrecioGeneral();
        //10 % de descuento
        precioEntrada = precioEntrada -(precioEntrada * porcentajedescuento);
        entrada.setPrecioFinal(precioEntrada);
    }
}