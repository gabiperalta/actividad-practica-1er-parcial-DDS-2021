package negocio.Tienda;

import negocio.Facturacion.Facturacion;

public class ProductoSimple extends Producto {
    @Override
    public void calcularPrecio() {
        this.getPrecio();
    }

    @Override
    public void generarFactura(Facturacion facturaVisitor) {

    }
}
