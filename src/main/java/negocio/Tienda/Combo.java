package negocio.Tienda;

import negocio.Facturacion.Facturacion;

import java.util.List;

public class Combo extends Producto {
    private int Porcentajedescuento;
    private List<Producto> productos;
    public Combo() {
        this.setPrecio(0);
    };
    @Override
    public int calcularPrecio() {


        int precioCombo = this.getPrecio();//sumar el precio de todos los productos
        for (Producto producto : productos)
        {
             precioCombo += producto.calcularPrecio();
        }
        precioCombo = calcularDescuento(precioCombo);
        this.setPrecio(precioCombo);
        return precioCombo;
    }

    @Override
    public void generarFactura(Facturacion facturaVisitor) {

    }
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    public int calcularDescuento(int precioCombo)
    {
        return  precioCombo - ((precioCombo * Porcentajedescuento)/100);
    }
    public void Porcentajedescuento(int porcentajedescuento)
    {
        this.Porcentajedescuento = porcentajedescuento;
    }
}

