package negocio.TestCine;
import negocio.Cine.Entrada;
import negocio.Cliente.Cliente;
import negocio.Promocion.Miercoles;
import negocio.Promocion.Promocion;
import negocio.pelicula.Pelicula;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestEntrada {
    @BeforeClass
    public static void init(){

    }
    @Test
    //Calcular precio combo pochoclero con 5% de descuento
    public void TestPrecioEntrada(){
        Cliente cliente = new Cliente();
        Promocion promocion = new Miercoles();
        Pelicula pelicula = new Pelicula();
        //Date fechaTransmision = new Date(2021,10,16);
        Entrada entrada = new Entrada(cliente,1,200,promocion, pelicula);
        promocion.precioEntradas(entrada);
        Assert.assertEquals(150,entrada.getPrecioFinal());
    }
}
