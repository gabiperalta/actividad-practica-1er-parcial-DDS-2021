package negocio.Tienda;

import negocio.Facturacion.Facturacion;

import java.util.List;

public class Combo extends Producto {
    private int descuento;
    private List<Producto> productos;
    public Combo(int precio) {
        this.setPrecio(0);
    };
    @Override
    public double calcularPrecio() {


        double precioCombo = this.getPrecio();//sumar el precio de todos los productos
        for (Producto producto : productos)
        {
             precioCombo += producto.calcularPrecio();
        }
        this.setPrecio(precioCombo);
        return precioCombo;
    }

    @Override
    public void generarFactura(Facturacion facturaVisitor) {

    }
    public void calcularDescuento()
    {
        //Calcular el descuento
    }
}

