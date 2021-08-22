package negocio.TestCine;
import com.sun.org.apache.xpath.internal.operations.Equals;
import negocio.Cine.Entrada;
import negocio.Cine.Funcion;
import negocio.Cine.Pelicula;
import negocio.Cineasta.Cliente;
import negocio.Promocion.Miercoles;
import negocio.Promocion.Promocion;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import sun.awt.windows.WPrinterJob;

import java.util.Date;

import static negocio.Cine.Dia.Martes;

public class TestEntrada {
    @BeforeClass
    public static void init(){

    }
    @Test
    //Calcular precio combo pochoclero con 5% de descuento
    public void TestPrecioEntrada(){
        Cliente cliente = new Cliente("Natalia","Ramirez");
        Promocion promocion = new Miercoles();
        Date fechaTransmision = new Date(2021,12,12,16,30,00);
        Pelicula pelicula = new Pelicula();
        Funcion funcion = new Funcion(23,100,100,200,Martes,fechaTransmision,pelicula);
        //Date fechaTransmision = new Date(2021,10,16);
        Entrada entrada = new Entrada(cliente,1,200,promocion,funcion);
        promocion.precioEntradas(entrada);
        Assert.assertEquals(150,entrada.getPrecioFinal());
        //Assert.assertEquals(150,firstDate3);
       //Assert.assertEquals(150,fechaTransmision.getDay());
       // Assert.assertEquals(150,firstDate3.getMonth());
        //Assert.assertEquals(150,firstDate3.getYear());
       // Assert.assertEquals(150,firstDate3.getHours());
        //Assert.assertEquals(30,firstDate3.getMinutes());
    }
}
