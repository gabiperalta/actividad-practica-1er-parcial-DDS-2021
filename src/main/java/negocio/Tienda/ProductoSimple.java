package negocio.Tienda;

import negocio.Facturacion.Facturacion;

public class ProductoSimple extends Producto {
    @Override
    public int calcularPrecio() {
        return this.getPrecio();
    }

    @Override
    public void generarFactura(Facturacion facturaVisitor) {

    }
    public ProductoSimple(int precio) {
        this.setPrecio(precio);
    };
}
