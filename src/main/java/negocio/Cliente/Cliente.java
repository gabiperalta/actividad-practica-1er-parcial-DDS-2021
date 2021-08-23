package negocio.Cliente;

import negocio.Cine.Entrada;
import negocio.Cine.Funcion;
import negocio.Tienda.Producto;

import java.util.List;

public class Cliente {
    private String nombre;
    private String apellido;
    private List<Entrada> entradas;
    private List<Entrada> reservas;
    private List<Producto> combos;

    public Cliente(){

    }

    /*public void reservarEntrada(Funcion funcion,String filaColumna)
    {
        this.reservas.add(funcion.reservarEntrada(funcion,filaColumna));
    }
    public void comprar_entrada(Funcion funcion,String filaColumna){
        this.entradas.add(funcion.reservarEntrada(funcion,filaColumna));
    }
    public void comprar_combo(Producto producto){
        this.combos.add(producto);
    }*/

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
