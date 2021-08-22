package negocio.Cine;

import negocio.Cliente.Cliente;
import negocio.Tienda.Tienda;


import java.util.List;

public class Cine {
    private static Cine instance = null;
    private List<Funcion> funciones;
    private List<Cliente> clientes;
    private Tienda tienda;

    private Cine(){
    }
    public static Cine getInstance(){
        if(instance == null){
            instance = new Cine();
        }
        return instance;
    }

}
