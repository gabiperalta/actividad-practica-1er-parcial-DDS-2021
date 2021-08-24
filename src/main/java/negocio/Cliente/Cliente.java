package negocio.Cliente;

import negocio.Boleto.Boleto;
import negocio.Boleto.Entrada;
import negocio.Cine.Funcion;
import negocio.Boleto.Reserva;
import negocio.Tienda.Producto;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String apellido;
    private List<Boleto> entradas;
    private List<Boleto> reservas;
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

    public List<Boleto> getEntradas(){return this.entradas;};
    public List<Boleto> getReservas(){return this.reservas;};
    public void setEntradas(List<Boleto> entradas){this.entradas = entradas;};
    public void setReservas(List<Boleto> reservas){this.reservas = reservas;};
    public void removeReserva(Boleto reserva){this.reservas.remove(reserva);};
    public void addReserva(Boleto reserva){this.reservas.add(reserva);};
    public void removeEntrada(Boleto entrada){this.entradas.remove(entrada);};
    public void addEntrada(Boleto entrada){this.entradas.add(entrada);};

    public void pedirEntradaporfila(Funcion funcion,String filaColumna)
    {
        Boleto nuevaEntrada;
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
                Boleto nuevaEntrada = funcion.entradaAleatoria(this);
                this.addEntrada(nuevaEntrada);
            }
            else
            {
                //No hay mas entradas para la funcion solicitada
            }
    }
    public void pedirReserva(Funcion funcion,String filaColumna)
    {
        Boleto nuevaReserva;
        if(funcion.validarUbicacion(filaColumna))
        { nuevaReserva =  funcion.solicitarReserva(filaColumna,this);
            this.addReserva(nuevaReserva);
        }
        //Si no hay ubicacion para esa columna fila debe seleccionar otra el sistema no le dara opciones
    }

}
