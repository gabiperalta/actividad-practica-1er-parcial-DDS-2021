package negocio.TestCliente;

import negocio.Cine.Funcion;
import negocio.Cliente.Cliente;
import negocio.pelicula.Pelicula;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static negocio.Cine.Dia.Martes;

public class TestCliente {
    @BeforeClass
    public static void init(){

    }
    @Test
    //Calcular precio combo pochoclero con 5% de descuento
    public void TestPedirEntrada(){
        Cliente cliente = new Cliente("Natalia","Ramirez");
        Date fechaTransmision = new Date(2021,12,12,16,30,00);
        List<String> generos =new ArrayList<>();
        generos.add("Drama");
        List<String> actores =new ArrayList<>();
        actores.add("ActorA");
        LocalDate estreno = LocalDate.now();
        Pelicula pelicula = new Pelicula("HP",generos,actores,estreno);
        HashMap<String,Boolean> ubicaciones = new HashMap<String,Boolean>()
        {{
            put("M9", true);
            put("M10", false);
        }};
        HashMap<String,Boolean> ubicaciones2= new HashMap<String,Boolean>()
        {{
            put("M8", true);
            put("M10", false);
        }};
        Funcion funcion = new Funcion(23,100,100,200,Martes,fechaTransmision,pelicula);
        funcion.setUbicaciones(ubicaciones);
        cliente.pedirEntradaporfila(funcion,"M9");
        Assert.assertEquals(1,cliente.getEntradas().size());
    }
}
