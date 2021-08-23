package negocio.Cliente;

import negocio.Boleto.Entrada;
import negocio.Cine.Funcion;
import negocio.Boleto.Reserva;
import negocio.Tienda.Producto;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String apellido;
    private List<Entrada> entradas;
    private List<Reserva> reservas;
    private List<Producto> combos;

    //test

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

    public void pedirEntradaporfila(Funcion funcion,String filaColumna)
    {
        Entrada nuevaEntrada;
        if(funcion.validarUbicacion(filaColumna))
        {
            nuevaEntrada =  funcion.solicitarEntrada(filaColumna,this);
           this.addEntrada(nuevaEntrada);
        }
    }
    public void pedirEntradaaleatoria(Funcion funcion)
    {
            if(funcion.getAsientosLibres() >0)
            {
                Entrada nuevaEntrada = funcion.entradaAleatoria(this);
                this.addEntrada(nuevaEntrada);
            }
            else
            {
                //No hay mas entradas para la funcion solicitada
            }
    }
    public void pedirReserva(Funcion funcion,String filaColumna)
    {
        Reserva nuevaReserva;
        if(funcion.validarUbicacion(filaColumna))
        { nuevaReserva =  funcion.solicitarReserva(filaColumna,this);
            this.addReserva(nuevaReserva);
        }
        //Si no hay ubicacion para esa columna fila debe seleccionar otra el sistema no le dara opciones
    }

}
