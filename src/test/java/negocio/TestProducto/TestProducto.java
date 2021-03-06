package negocio.TestProducto;

import negocio.Tienda.Combo;
import negocio.Tienda.Producto;
import negocio.Tienda.ProductoSimple;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

public class TestProducto {
    @BeforeClass
    public static void init(){

    }
    @Test
    //Calcular precio combo pochoclero con 5% de descuento
    public void TestCombo(){
        Combo combo = new Combo("Combo cine", "COMBO55");
        ProductoSimple gaseosa = new ProductoSimple("Coca Cola 500 ml","CC500",50);
        ProductoSimple pochoclos = new ProductoSimple("Pororo","P100",100);
        List<Producto> productos = new ArrayList<>();
        productos.add(gaseosa);
        productos.add(pochoclos);
        combo.setProductos(productos);
        combo.setPorcentajedescuento(5);
        Assert.assertEquals(143,combo.calcularPrecio());
    }
}

