package co.edu.uco.tiendachepito.data.DAO.sql.azuresql;

import co.edu.uco.tiendachepito.data.DAO.DepartamentoDAO;
import co.edu.uco.tiendachepito.data.DAO.sql.SqlConnection;
import co.edu.uco.tiendachepito.entity.DepartamentoEntity;

import java.sql.Connection;
import java.util.List;

public final class DepartamentoAzureSqlDAO extends SqlConnection implements DepartamentoDAO {

    public DepartamentoAzureSqlDAO(final Connection connection){
        super(connection);
    }

    @Override
    public final void actualizar(final DepartamentoEntity entidad) {
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("UPDATE Departamento");
        sentenciaSql.append("SET Nombre = 'Atlantico' ");
        sentenciaSql.append("WHERE Id = '1'");
    }

    @Override
    public final List<DepartamentoEntity> consultar(final DepartamentoEntity entidad) {
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("SELECT  Id, Nombre");
        sentenciaSql.append("FROM Departamento");
        sentenciaSql.append("ORDER BY Nombre ASC");
        return null;
    }

    @Override
    public final void crear(final DepartamentoEntity entidad) {
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("INSERT INTO Departamento(Nombre)");
        sentenciaSql.append("VALUES('Antioquia')");
    }

    @Override
    public final void eliminar(final int id) {
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("DELETE FROM Departamento");
        sentenciaSql.append("WHERE Id = '1'");
    }
}
