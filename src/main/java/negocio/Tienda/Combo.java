package negocio.Tienda;

import negocio.Facturacion.Facturacion;

import java.util.List;

public class Combo extends Producto {
    private int descuento;
    private List<Producto> productos;
    @Override
    public void calcularPrecio() {
        this.getPrecio();//sumar el precio de todos los productos
    }

    @Override
    public void generarFactura(Facturacion facturaVisitor) {

    }
    public void calcularDescuento()
    {
        //Calcular el descuento
    }
}

