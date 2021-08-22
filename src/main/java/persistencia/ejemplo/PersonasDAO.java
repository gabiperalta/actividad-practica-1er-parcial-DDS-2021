package persistencia.ejemplo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonasDAO {
    private Connection conn;

    public PersonasDAO(Connection connection){
        this.conn = connection;
    }

    public List<Persona> selectActivas() {
        try {
            // generacion de query
            String consulta = "SELECT * FROM persona WHERE activo = 1";

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
