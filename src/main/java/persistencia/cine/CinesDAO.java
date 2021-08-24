package persistencia.cine;

import negocio.Cine.Cine;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CinesDAO {
    private Connection conn;

    public CinesDAO(Connection connection){
        this.conn = connection;
    }

    /*
    public List<Cine> selectActivos(){
        try {
            // generacion de query
            String consulta = "SELECT * FROM cine";

            // Ejecucion
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            // Recorrer y usar cada linea retornada
            List<Cine> cines = new ArrayList<>();

            while (rs.next()) {
                Cine obj = new Cine();

                // get nombre y apellido
                String str = rs.getString("nombre");
                String[] newStr = str.split("\\s+");
                obj.setNombre(newStr[0]);
                obj.setApellido(newStr[1]);

                // get edad
                obj.setEdad(rs.getInt("edad"));

                personas.add(obj);
            }
            return personas;
        } catch (SQLException ex) {

            // handle any errors
            System.out.println("Error en Select");
            return null;
        }
    }
     */
}
