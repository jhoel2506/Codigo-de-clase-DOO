package co.edu.uco.tiendachepito.data.dao.sql.azuresql;

import java.sql.Connection;

public class SqlConnection {
    private Connection connection;

    protected SqlConnection(final Connection connection) {
        this.connection = connection;
    }

    public final void setConnection(final Connection connection) {
        // TODO: se debe validar que la conexion este abierta
        this.connection = connection;
    }

    protected final Connection getConnection() {
        return connection;
    }
}
