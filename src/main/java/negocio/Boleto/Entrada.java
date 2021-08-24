package negocio.Boleto;

public class Entrada extends EstadoBoleto {
   private int descuentProductos;
   public void aplicarDescuento(int descuento)
   {
       this.descuentProductos= descuento;
   }
}
