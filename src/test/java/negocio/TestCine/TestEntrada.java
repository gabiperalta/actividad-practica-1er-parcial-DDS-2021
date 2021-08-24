package negocio.TestCine;

import negocio.Boleto.Boleto;
import negocio.Boleto.Entrada;
import negocio.Cine.Dia;
import negocio.Cine.Funcion;
import negocio.Cliente.Cliente;
import negocio.Promocion.Miercoles;
import negocio.pelicula.Pelicula;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class TestEntrada {
    @BeforeClass
    public static void init(){

    }
    @Test
    //Calcular precio combo pochoclero con 5% de descuento
    public void TestPrecioEntrada(){
        Cliente cliente = new Cliente("Natalia","Ramirez");
        Date fechaTransmision = new Date(2021, Calendar.AUGUST,12,16,30, 0);
        String generos = "Drama";
        String actores = "ActorA";
        Date estreno = new Date();
        Pelicula pelicula = new Pelicula("HP",generos,actores,estreno);
        Funcion funcion = new Funcion(23,100,100,200,Dia.Miercoles,fechaTransmision,pelicula);
        funcion.setPromocion();
        Boleto entrada = new Boleto(cliente,funcion,"M9",new Entrada());
        Miercoles sinP = new Miercoles();
        Assert.assertEquals(150,entrada.getPrecioFinal());
    }
}
