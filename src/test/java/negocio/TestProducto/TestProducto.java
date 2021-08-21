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
        Combo combo = new Combo();
        ProductoSimple gaseosa = new ProductoSimple(50);
        ProductoSimple pochoclos = new ProductoSimple(100);
        List<Producto> productos = new ArrayList<>();
        productos.add(gaseosa);
        productos.add(pochoclos);
        combo.setProductos(productos);
        combo.Porcentajedescuento(5);
        Assert.assertEquals(143,combo.calcularPrecio());

    }
}

