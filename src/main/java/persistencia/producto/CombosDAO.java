package persistencia.producto;

import negocio.Tienda.Combo;
import negocio.Tienda.Producto;
import negocio.Tienda.ProductoSimple;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CombosDAO {
    private Connection conn;

    public CombosDAO(Connection connection){
        this.conn = connection;
    }

    /*
    public List<Producto> selectAll(){
        try {
            // generacion de query
            String consulta = "SELECT * FROM combo c " +
                    "inner join producto p on p.id = ps.id_producto" +
                    "inner join productoSimple ps on ps.id_combo = c.id " +
                    "order by c.id";

            // Ejecucion
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            // Recorrer y usar cada linea retornada
            List<Producto> combos = new ArrayList<>();

            int idComboActual;
            int idComboAnterior = -1;
            Combo obj = new Combo();
            while (rs.next()) {
                idComboActual = rs.getInt("c.id");
                if(idComboAnterior != idComboActual) {
                    obj = new Combo();
                    idComboAnterior = idComboActual;
                }

                obj.setNombre(rs.getString("nombre"));
                obj.setCodigo(rs.getString("codigo"));
                combos.add(obj);
            }
            return productosSimples;
        } catch (SQLException ex) {
            System.out.println("Error en Select");
            return null;
        }
    }

     */

    public List<Producto> selectAll(){
        try {
            // generacion de query
            String consulta = "SELECT * FROM combo";

            // Ejecucion
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            ProductosSimplesDAO productosSimplesDAO = new ProductosSimplesDAO(conn);

            // Recorrer y usar cada linea retornada
            List<Producto> combos = new ArrayList<>();

            while (rs.next()) {
                Combo obj = new Combo();

                obj.setNombre(rs.getString("nombre"));
                obj.setCodigo(rs.getString("codigo"));
                obj.setProductos(productosSimplesDAO.selectPorCombo(rs.getInt("id")));
                combos.add(obj);
            }
            return combos;
        } catch (SQLException ex) {
            System.out.println("Error en Select");
            return null;
        }
    }
}
