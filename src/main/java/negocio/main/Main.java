package negocio.main;

import persistencia.Conexion;
import persistencia.ejemplo.Persona;
import persistencia.ejemplo.PersonasDAO;

import java.io.IOException;
import java.util.List;

public class Main {

    private static List<Persona> personas;

    public static void main(String[] args) throws IOException {
        // Altas
        Persona pers1 = new Persona("Juan", "Lopez", 33);
        System.out.println("Nueva persona cargada con ID " + pers1.getId());
        Persona pers2 = new Persona("Maria", "Dolte", 12);
        System.out.println("Nueva persona cargada con ID " + pers2.getId());
        Persona pers3 = new Persona("Antoine", "Derrida", 57);
        System.out.println("Nueva persona cargada con ID " + pers3.getId());

        // Inactivar a Mar�a Dolte
        if (pers2.baja())
            System.out.println("Baja realizada de ID " + pers2.getId());

        // Dar de baja a Antoine
        if (pers3.bajaTotal())
            System.out.println("Baja realizada de ID " + pers3.getId());

        // Recorrer todas las personas
        PersonasDAO oPersonaDAO = new PersonasDAO(Conexion.getInstance().getConnection());
        personas = oPersonaDAO.selectActivas();
        System.out.println("Actualmente hay " + personas.size() + " personas activas");
    }
}
