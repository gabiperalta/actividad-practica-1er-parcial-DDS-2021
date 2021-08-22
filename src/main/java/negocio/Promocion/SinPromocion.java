package negocio.Promocion;

import negocio.Boleto.Entrada;

public class SinPromocion extends Promocion {
    private static int porcentajedescuento = 0;
    public int setPorcentajedescuento()
    {
        return this.porcentajedescuento;
    }
    @Override
    public void precioEntradas(Entrada entrada) {
        int precioEntrada = entrada.getPrecioGeneral();
        //0 % de descuento
        int precio = precioEntrada - ((precioEntrada * porcentajedescuento)/100);
        entrada.setPrecioFinal(precio);
    }
}
