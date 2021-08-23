package persistencia.funcion;

import negocio.Cine.Funcion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FuncionesDAO {
    private Connection conn;

    public FuncionesDAO(Connection connection){
        this.conn = connection;
    }

    public List<Funcion> selectAll(){
        try {
            // generacion de query
            String consulta = "SELECT * FROM funcion";

            // Ejecucion
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            // Recorrer y usar cada linea retornada
            List<Funcion> funciones = new ArrayList<>();

            while (rs.next()) {
                Funcion obj = new Funcion();

                obj.setNumeroSala(rs.getInt("numero_sala"));
                obj.setAsientosLibres(rs.getInt("asientos_libres"));
                obj.setAsientosTotales(rs.getInt("asientos_totales"));
                obj.setDia(rs.getString("dia"));
                obj.setHorarioInicio(null); // TODO revisar como guardamos las fechas en java
                obj.setHorarioFin(null); // TODO revisar como guardamos las fechas en java
                obj.setPrecioGeneral(rs.getInt("precio_general")); // TODO revisar si guardamos el precio como int o como decimal

                // TODO falta obtener la pelicula

                funciones.add(obj);
            }
            return funciones;
        } catch (SQLException ex) {
            System.out.println("Error en Select");
            return null;
        }
    }
}
