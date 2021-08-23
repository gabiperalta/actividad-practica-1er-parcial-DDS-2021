package persistencia.entrada;

import negocio.Cine.Entrada;
import persistencia.cliente.ClientesDAO;
import persistencia.pelicula.PeliculasDAO;
import persistencia.promocion.PromocionesDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EntradasDAO {
    private Connection conn;

    public EntradasDAO(Connection connection){
        this.conn = connection;
    }

    public List<Entrada> selectAll(){
        try {
            // generacion de query
            String consulta = "SELECT * FROM entrada";

            // Ejecucion
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            ClientesDAO clientesDAO = new ClientesDAO(conn);
            PromocionesDAO promocionesDAO = new PromocionesDAO(conn);
            PeliculasDAO peliculasDAO = new PeliculasDAO(conn);

            // Recorrer y usar cada linea retornada
            List<Entrada> entradas = new ArrayList<>();

            while (rs.next()) {
                Entrada obj = new Entrada();

                obj.setCliente(clientesDAO.select(rs.getInt("id_cliente")));
                obj.setNumeroSala(rs.getInt("numero_sala"));
                obj.setPrecioGeneral(rs.getInt("precio_general")); // TODO revisar si guardamos el precio como int o como decimal
                obj.setPromocion(promocionesDAO.select(rs.getInt("id_promocion")));
                obj.setPelicula(peliculasDAO.select(rs.getInt("id_pelicula")));

                entradas.add(obj);
            }
            return entradas;
        } catch (SQLException ex) {
            System.out.println("Error en Select");
            return null;
        }
    }
}
