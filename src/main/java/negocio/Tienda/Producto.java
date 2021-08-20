package negocio.Tienda;

import negocio.Facturacion.Facturacion;

public abstract class Producto {
    private String  nombre;
    private String codigo;
    private double precio;

    abstract public void calcularPrecio ();
    abstract public void generarFactura(Facturacion facturaVisitor);

    public double getPrecio() {
        return precio;
    }
}
