package persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonasDAO {
    private Connection conn;

    public Connection newConnection() {
        Connection conn = null;
        try {
            String connectionUrl = "jdbc:mysql://localhost:3306/dds";
            //connectionUrl = "jdbc:mysql://localhost:3306/dds3?serverTimezone=UTC";
            conn = DriverManager.getConnection(connectionUrl, "root", "1234");

            // Do something with the Connection
            //System.out.println("Conexion realizada");

            return conn;

        } catch (SQLException ex) {

            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return null;
        }
    }

    public List<Persona> selectActivas() {
        try {
            // generacion de query
            String consulta = "SELECT * FROM persona WHERE activo = 1";

            // Conexion
            this.conn = newConnection();

            // Ejecucion
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            // Recorrer y usar cada linea retornada
            List<Persona> personas = new ArrayList<>();

            while (rs.next()) {
                Persona obj = new Persona();

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
}
