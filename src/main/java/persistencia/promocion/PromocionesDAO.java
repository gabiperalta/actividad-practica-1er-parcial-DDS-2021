package persistencia.promocion;

import negocio.Cliente.Cliente;
import negocio.Promocion.Miercoles;
import negocio.Promocion.Promocion;

import java.sql.Connection;

public class PromocionesDAO {
    private Connection conn;

    public PromocionesDAO(Connection connection){
        this.conn = connection;
    }

    public Promocion select(int idPromocion){
        return new Miercoles(); // TODO debe variar segun lo que este en la tabla
    }
}
