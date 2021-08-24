package negocio.TestCine;
import negocio.Boleto.Boleto;
import negocio.Boleto.Entrada;
import negocio.Cine.Dia;
import negocio.Cine.Funcion;
import negocio.Cliente.Cliente;
import negocio.Promocion.Miercoles;
import negocio.Promocion.Promocion;
import negocio.Promocion.SinPromocion;
import negocio.pelicula.Pelicula;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        List<String> generos =new ArrayList<>();
        generos.add("Drama");
        List<String> actores =new ArrayList<>();
        actores.add("ActorA");
        LocalDate estreno = LocalDate.now();
        Pelicula pelicula = new Pelicula("HP",generos,actores,estreno);
        Funcion funcion = new Funcion(23,100,100,200,Dia.Miercoles,fechaTransmision,pelicula);
        funcion.setPromocion();
        Boleto entrada = new Boleto(cliente,funcion,"M9",new Entrada());
        Miercoles sinP = new Miercoles();
        //Assert.assertEquals(150,entrada.getPrecioFinal());
       Assert.assertEquals(150,entrada.getPrecioFinal());
    }
}
