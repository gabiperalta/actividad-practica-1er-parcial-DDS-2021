package persistencia.cliente;

import negocio.Cliente.Cliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientesDAO {
    private Connection conn;

    public ClientesDAO(Connection connection){
        this.conn = connection;
    }

    public Cliente select(int idCliente){
        return new Cliente();
    }
}
