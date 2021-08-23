package persistencia.pelicula;

import negocio.pelicula.Pelicula;

import java.sql.*;

public class PeliculaDAO {
    private final Connection conn;

    public PeliculaDAO(Connection connection){
        this.conn = connection;
    }

}

/*
public class PersonaDAO {

    private final Connection conn;

    public PersonaDAO(Connection connection){
        this.conn = connection;
    }

    public int insert(String nombre, int edad) {
        String consulta = "INSERT INTO persona (nombre, edad) VALUES ('" + nombre + "'," + edad + ");";

        try {
            // Ejecuci�n
            PreparedStatement stmt = this.conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);

            // execute the preparedstatement
            stmt.executeUpdate();

            // obtener �ltimo id generado
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next())
                return generatedKeys.getInt(1);
            else
                return 0;


        } catch (SQLException ex) {

            // handle any errors
            System.out.println("Error en Insert");
            return 0;
        }

    }

    public boolean updateActivo(int idPersona) {
        String consulta = "UPDATE persona SET activo = 0 WHERE id = " + idPersona + ";";

        try {

            // Ejecuci�n
            PreparedStatement stmt = this.conn.prepareStatement(consulta);

            // execute the preparedstatement
            stmt.executeUpdate();
            return true;


        } catch (SQLException ex) {

            // handle any errors
            System.out.println("Error en Update");
            return false;
        }

    }

    public boolean delete(int idPersona) {
        String consulta = "DELETE FROM persona WHERE id = " + idPersona + ";";

        try {

            // Ejecuci�n
            PreparedStatement stmt = this.conn.prepareStatement(consulta);

            // execute the preparedstatement
            stmt.execute();
            return true;

        } catch (SQLException ex) {

            // handle any errors
            System.out.println("Error en Delete");
            return false;
        }

    }

}
 */