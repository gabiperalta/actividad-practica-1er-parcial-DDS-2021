package negocio.Promocion;

import negocio.Cine.Entrada;

public class FinDeSemana extends Promocion {
    private static int porcentajedescuento = 10;
    public int setPorcentajedescuento()
    {
        return this.porcentajedescuento;
    }
    @Override
    public void precioEntradas(Entrada entrada) {
        int precioEntrada = entrada.getPrecioGeneral();
        //10 % de descuento
        int precio = precioEntrada - ((precioEntrada * porcentajedescuento)/100);
        entrada.setPrecioFinal(precio);
    }

}