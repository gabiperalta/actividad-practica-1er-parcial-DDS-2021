package negocio.Tienda;

import negocio.Facturacion.Facturacion;

public abstract class Producto {
    private String  nombre;
    private String codigo;
    private int precio;

    abstract public int calcularPrecio ();
    public void generarFactura(Facturacion faturador)
    {
        faturador.generarFacturaProducto(this);
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
