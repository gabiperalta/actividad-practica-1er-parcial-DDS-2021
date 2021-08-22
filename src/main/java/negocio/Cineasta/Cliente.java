package negocio.Cineasta;

import negocio.Cine.Entrada;
import negocio.Cine.Funcion;
import negocio.Cine.Reserva;
import negocio.Tienda.Producto;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String apellido;
    private List<Entrada> entradas;
    private List<Reserva> reservas;
    private List<Producto> combos;

    public Cliente(String nombre,String apellido)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.entradas = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.combos = new ArrayList<>();
    }

    public List<Entrada> getEntradas(){return this.entradas;};
    public List<Reserva> getReservas(){return this.reservas;};
    public void setEntradas(List<Entrada> entradas){this.entradas = entradas;};
    public void setReservas(List<Reserva> reservas){this.reservas = reservas;};
    public void removeReserva(Reserva reserva){this.reservas.remove(reserva);};
    public void addReserva(Reserva reserva){this.reservas.add(reserva);};
    public void removeEntrada(Entrada entrada){this.entradas.remove(entrada);};
    public void addEntrada(Entrada entrada){this.entradas.add(entrada);};

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
    public void validarEntrada(Funcion funcion,String filaColumna)
    {
        if(funcion.validarUbicacion(filaColumna))
        {
           Entrada nuevaEntrada =  funcion.solicitarEntrada(filaColumna,this);
           this.addEntrada(nuevaEntrada);
        }
        else
        {

        }
    }

}
