package negocio.Tienda;

import negocio.Facturacion.Facturacion;

public class ProductoSimple extends Producto {
    @Override
    public double calcularPrecio() {
        return this.getPrecio();
    }

    @Override
    public void generarFactura(Facturacion facturaVisitor) {

    }
}
