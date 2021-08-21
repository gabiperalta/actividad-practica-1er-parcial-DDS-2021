package negocio.Promocion;

import negocio.Cine.Entrada;

public abstract class Promocion {
    private static int Porcentajedescuento;

    public int getPorcentajedescuento()
    {
        return this.Porcentajedescuento;
    }
    public void setPorcentajedescuento(int porcentaje)
    {
        this.Porcentajedescuento = porcentaje;
    }
    abstract public void precioEntradas(Entrada entrada);
}
